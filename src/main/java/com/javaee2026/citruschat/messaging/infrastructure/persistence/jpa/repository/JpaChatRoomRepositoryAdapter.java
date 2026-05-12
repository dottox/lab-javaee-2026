package com.javaee2026.citruschat.messaging.infrastructure.persistence.jpa.repository;

import com.javaee2026.citruschat.messaging.application.ports.IChatRoomRepository;
import com.javaee2026.citruschat.messaging.domain.model.ChatRoom;
import com.javaee2026.citruschat.messaging.infrastructure.persistence.jpa.mapper.ChatRoomMapper;
import jakarta.transaction.Transactional;

public class JpaChatRoomRepositoryAdapter implements IChatRoomRepository {

	private final SpringDataChatRoomRepository chatRoomRepository;
	private final ChatRoomMapper chatRoomMapper;

	public JpaChatRoomRepositoryAdapter(SpringDataChatRoomRepository chatRoomRepository,
			ChatRoomMapper chatRoomMapper) {
		this.chatRoomRepository = chatRoomRepository;
		this.chatRoomMapper = chatRoomMapper;
	}

	@Override
	@Transactional
	public void save(ChatRoom chatRoom) {
		chatRoomRepository.save(ChatRoomMapper.toJpa(chatRoom));
	}
}
