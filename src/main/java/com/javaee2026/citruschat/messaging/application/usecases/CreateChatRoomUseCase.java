package com.javaee2026.citruschat.messaging.application.usecases;

import com.javaee2026.citruschat.identity.application.ports.IUserRepository;
import com.javaee2026.citruschat.messaging.application.commands.CreateChatRoomCommand;
import com.javaee2026.citruschat.messaging.application.ports.IChatRoomRepository;
import com.javaee2026.citruschat.messaging.domain.factory.ChatRoomFactory;
import com.javaee2026.citruschat.messaging.domain.model.ChatRoom;
import com.javaee2026.citruschat.shared.domain.valueobjects.UserId;

public class CreateChatRoomUseCase {

	private final IChatRoomRepository chatRoomRepository;
	private final ChatRoomFactory chatRoomFactory;
	private final IUserRepository userRepository;

	public CreateChatRoomUseCase(IChatRoomRepository chatRoomRepository, ChatRoomFactory chatRoomFactory,
			IUserRepository userRepository) {
		this.chatRoomRepository = chatRoomRepository;
		this.chatRoomFactory = chatRoomFactory;
		this.userRepository = userRepository;
	}

	public void execute(CreateChatRoomCommand command) {

		UserId creatorId = new UserId(command.chatRoomCreatorId());

		ChatRoom chatRoom = chatRoomFactory.createNew(command.chatRoomType(), command.name(), creatorId);

		if (userRepository.findById(creatorId).isEmpty()) {
			throw new IllegalArgumentException("Creator user does not exist");
		}

		chatRoomRepository.save(chatRoom);
	}
}
