package org.huuloc.departmentservice.exception;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    private String message;
    private String description;
    private int code;
    private LocalDateTime timestamp;
}
