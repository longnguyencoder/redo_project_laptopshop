package com.example.redo_project.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationResponse {
    // biến này true là user cung cấp pass đúng
    String Token;
    boolean authenticated;
}
