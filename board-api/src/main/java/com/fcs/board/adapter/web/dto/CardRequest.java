package com.fcs.board.adapter.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CardRequest(@NotNull Long columnId, @NotBlank String title, String description) {}
