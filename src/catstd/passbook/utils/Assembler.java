package catstd.passbook.utils;

import catstd.passbook.activities.parcelable.UserParcelable;
import catstd.passbook.dao.dto.User;

public class Assembler {

    public static UserParcelable assemble(User source) {
        UserParcelable dest = new UserParcelable();
        dest.setId(source.getId());
        dest.setUsername(source.getUsername());
        dest.setFullname(source.getFullname());
        dest.setPassword(source.getPassword());
        return dest;
    }
    
    public static User assemble(UserParcelable source) {
        User dest = new User();
        dest.setId(source.getId());
        dest.setUsername(source.getUsername());
        dest.setFullname(source.getFullname());
        dest.setPassword(source.getPassword());
        return dest;
    }
    
    private Assembler() {}
    
}
