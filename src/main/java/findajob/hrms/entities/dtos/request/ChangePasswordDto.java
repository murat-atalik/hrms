package findajob.hrms.entities.dtos.request;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordDto {


private int userId;
private String oldPassword;
private String newPassword;
}
