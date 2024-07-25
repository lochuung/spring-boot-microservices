package org.huuloc.departmentservice.exception;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BadRequestException extends RuntimeException {
    private String message;
    private int code;

    public static BadRequestException message(String s) {
        return BadRequestException.builder()
                .message(s)
                .code(400)
                .build();
    }
}
