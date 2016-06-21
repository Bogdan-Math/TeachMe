package ua.teachme.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordTO {

    private String oldPassword;
    private String newPassword;
    private String newPasswordRepeated;

    public PasswordTO() {
    }

    public PasswordTO(String oldPassword, String newPassword, String newPasswordRepeated) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.newPasswordRepeated = newPasswordRepeated;
    }

    @Override
    public String toString() {
        return "PasswordTO{" +
                "oldPassword='" + oldPassword + '\'' +
                ", newPassword='" + newPassword + '\'' +
                ", newPasswordRepeated='" + newPasswordRepeated + '\'' +
                '}';
    }
}
