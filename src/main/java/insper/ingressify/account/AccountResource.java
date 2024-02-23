package insper.ingressify.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jersey.JerseyProperties.Servlet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class AccountResource implements AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/accounts/info")
    public String info() {
        return "Account service";
    }

    @Override
    public ResponseEntity<AccountOut> create(AccountIn in) {
        Account account = AccountParser.to(in);
        account = accountService.create(account);
        return ResponseEntity.created(
            ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(account.id())
            .toUri())
            .body(AccountParser.to(account));
    }

    @Override
    public ResponseEntity<AccountOut> update(String id, AccountIn in) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
}