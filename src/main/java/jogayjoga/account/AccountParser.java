package jogayjoga.account;

public class AccountParser {
    public static Account to(AccountIn in ){
        return Account.builder()
            .email(in.email())
            .name(in.name())
            .password(in.password())
            .build();
    }

    public static AccountOut to(Account in){
        return AccountOut.builder()
            .id(in.id())
            .email(in.email())
            .name(in.name())
            .build();
    }
}
