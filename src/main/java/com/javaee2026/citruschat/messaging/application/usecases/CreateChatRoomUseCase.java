package com.javaee2026.citruschat.messaging.application.usecases;

import com.javaee2026.citruschat.identity.application.ports.IUserRepository;
import com.javaee2026.citruschat.messaging.application.commands.CreateChatRoomCommand;
import com.javaee2026.citruschat.messaging.application.ports.IChatParticipantRepository;
import com.javaee2026.citruschat.messaging.application.ports.IChatRoomRepository;
import com.javaee2026.citruschat.messaging.domain.enums.ChatRoomType;
import com.javaee2026.citruschat.messaging.domain.factory.ChatParticipantFactory;
import com.javaee2026.citruschat.messaging.domain.factory.ChatRoomFactory;
import com.javaee2026.citruschat.messaging.domain.model.ChatParticipant;
import com.javaee2026.citruschat.messaging.domain.model.ChatRoom;
import com.javaee2026.citruschat.shared.domain.valueobjects.RoleId;
import com.javaee2026.citruschat.shared.domain.valueobjects.UserId;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class CreateChatRoomUseCase {

	private final IChatRoomRepository chatRoomRepository;
	private final ChatRoomFactory chatRoomFactory;
	private final IUserRepository userRepository;
	private final ChatParticipantFactory chatParticipantFactory;
	private final IChatParticipantRepository chatParticipantRepository;

	public CreateChatRoomUseCase(IChatRoomRepository chatRoomRepository, ChatRoomFactory chatRoomFactory,
			IUserRepository userRepository, ChatParticipantFactory chatParticipantFactory,
			IChatParticipantRepository chatParticipantRepository) {
		this.chatRoomRepository = chatRoomRepository;
		this.chatRoomFactory = chatRoomFactory;
		this.userRepository = userRepository;
		this.chatParticipantFactory = chatParticipantFactory;
		this.chatParticipantRepository = chatParticipantRepository;
	}

	public void execute(CreateChatRoomCommand command) {

		UserId creatorId = new UserId(command.chatRoomCreatorId());

		List<UserId> userIds = command.participantIds().stream().map(UserId::new).toList();

		if (command.chatRoomType() == ChatRoomType.DIRECT) {
			if (command.participantIds().size() != 1) {
				throw new IllegalArgumentException("Direct chat rooms must have exactly one participant");
			}
		}

		if (userRepository.findById(creatorId).isEmpty()) {
			throw new IllegalArgumentException("User with id " + creatorId + " does not exist");
		}

		if (userIds.contains(creatorId)) {
			throw new IllegalArgumentException("Creator cannot be participant twice");
		}

		for (UserId userId : userIds) {
			if (userRepository.findById(userId).isEmpty()) {
				throw new IllegalArgumentException("User with id " + userId + " does not exist");
			}
		}

		ChatRoom chatRoom = chatRoomFactory.createNew(command.chatRoomType(), command.name(), creatorId);

		// <- AQUI Falta la creacion del rol OWNER (idRoleOwner) y MEMBER (idRoleMember)

		RoleId idRoleOwner = RoleId.newId();
		RoleId idRoleMember = RoleId.newId();

		List<ChatParticipant> participantList = new ArrayList<>();

		participantList.add(chatParticipantFactory.createNew(chatRoom.getId(), creatorId, idRoleOwner, Instant.now()));

		for (UserId userId : userIds) {
			participantList
					.add(chatParticipantFactory.createNew(chatRoom.getId(), userId, idRoleMember, Instant.now()));
		}

		for (ChatParticipant chatParticipant : participantList) {
			chatParticipantRepository.save(chatParticipant);
			chatRoomRepository.addParticipantToChat(chatParticipant.getId(), chatRoom);
		}

		chatRoomRepository.save(chatRoom);
	}
}
