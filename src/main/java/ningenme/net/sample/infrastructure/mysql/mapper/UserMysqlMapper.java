package ningenme.net.sample.infrastructure.mysql.mapper;

import lombok.NonNull;
import ningenme.net.sample.infrastructure.mysql.dto.UserMysqlDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMysqlMapper {

    @Insert(
            "INSERT INTO user (code, id, mail, encrypted_password) " +
                    "VALUES (#{code},#{id},#{mail},#{encryptedPassword})"
    )
    void insert(@NonNull final UserMysqlDto userMysqlDto);

    @Select(
            "SELECT code, id, mail, encrypted_password FROM user " +
                    "WHERE mail = #{mail}"
    )
    UserMysqlDto selectByMail(@NonNull final String mail);

    @Select(
            "SELECT code, id, mail, encrypted_password FROM user " +
                    "WHERE code = #{code} AND id = #{id}"
    )
    UserMysqlDto selectByCodeAndId(@NonNull final String code, @NonNull final String id);

}
