package ningenme.net.sample.infrastructure.mysql.mapper;

import lombok.NonNull;
import ningenme.net.sample.infrastructure.mysql.dto.UserMysqlDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMysqlMapper {

    @Insert(
            "INSERT INTO user (code, id, mail, encrypted_password) " +
                    "VALUES (#{code},#{id},#{mail},#{encryptedPassword})"
    )
    void insert(@NonNull final UserMysqlDto userMysqlDto);

}
