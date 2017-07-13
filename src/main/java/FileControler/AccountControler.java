/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileControler;

import java.util.ArrayList;
import java.util.List;
import model.Account;

/**
 *
 * @author anhdau96
 */
public class AccountControler {
    List<Account> lstAcc;

    public AccountControler() {
        lstAcc = new ArrayList<>();
        lstAcc.add(new Account("700568107-6Ld3GG1qavoL9QTx4RmeNg4EcRQ7AXTKovGKHAIZ", "hsHiLhkXxLG9pvOdyyu0lg7GpFUh2F7mIsNXu7FelHD9U", "8Cxxg45V91Hqj7vVDRjx5bKbI", "GAaPJqWBh8a03eehdyiUf7LtO2xqw3C59H6vidYoWaY2zIgkEz"));
        lstAcc.add(new Account("877362500685021184-NIfophZWOI7lfTIG2ayZx1iyyAa3a3P", "pGx2eSEzJAm9SgrQIKlBRWXdeAUfoNqks0mGt1VXHzV2U", "kKZ5TrjirWe1ZKBDq94c9msIh", "MTFmshrvsc4Uiru9cKC5ldFXIMHD9n7HMnMBdgSWDBOlbvFkJB"));
        lstAcc.add(new Account("885035126446583808-vY6x93uVVajpI4rQM50m6VXZeVlpkFt", "nRWO4lQjwDGAi47oWW0KhTiE1PlUrkqPL66eX2Eeitvd4", "HnbKmnfal50LAzVjZ2silhwD6", "bZJh19YtpnLRf2IKhT381Gu9pmwl4L3vXBx3BjWcfSKqHO4nwl"));
    }
    
    public List<Account> getAll(){
        return lstAcc;
    }
}
