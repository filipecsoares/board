package com.fcs.board.adapter.web.dto;

import jakarta.validation.constraints.NotBlank;

public record BoardRequest(@NotBlank String name) {
}
