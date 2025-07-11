package com.fcs.board.adapter.web.dto;

import java.time.LocalDateTime;

public record CardResponse(Long id, Long columnId, String title, String description, LocalDateTime createdAt, boolean blocked) {}
