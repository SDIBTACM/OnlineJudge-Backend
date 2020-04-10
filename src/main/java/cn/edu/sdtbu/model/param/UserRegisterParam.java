package cn.edu.sdtbu.model.param;

import cn.edu.sdtbu.model.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * user register model
 * @author bestsort
 * @version 1.0
 * @date 2020-04-07 15:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterParam {
    @NotBlank
    private String username;

    @NotBlank
    private String nickname;

    @Size(min = 7)
    private String password;

    @NotBlank
    private String school;

    @Email
    @NotBlank
    private String email;

    public UserEntity transformToEntity() {
        return transformToEntity(new UserEntity());
    }
    public UserEntity transformToEntity(UserEntity userEntity) {
        BeanUtils.copyProperties(this, userEntity);
        return userEntity;
    }
}
