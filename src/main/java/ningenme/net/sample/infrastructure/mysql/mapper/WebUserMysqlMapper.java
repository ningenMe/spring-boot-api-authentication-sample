package ningenme.net.sample.infrastructure.mysql.mapper;

import lombok.NonNull;
import ningenme.net.sample.infrastructure.mysql.dto.WebUserMysqlDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface WebUserMysqlMapper {

    @Insert(
            "INSERT INTO web_user (code, id, mail, encrypted_password) " +
                    "VALUES (#{code},#{id},#{mail},#{encryptedPassword})"
    )
    void insert(@NonNull final WebUserMysqlDto userMysqlDto);

    @Select(
            "SELECT code, id, mail, encrypted_password FROM user " +
                    "WHERE mail = #{mail} LIMIT 1"
    )
    WebUserMysqlDto select(@NonNull final String mail);

}
