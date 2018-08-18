package alterindonesia.project.com.Utils;

import java.util.ArrayList;
import java.util.List;

import alterindonesia.project.com.Model.Merchant;

public class Data {

    public static List<Merchant> merchantList(){
        List<Merchant> merchants = new ArrayList<>();

        Merchant merchant = new Merchant();
        merchant.setNama("KFC Margonda Residence");
        merchant.setEmail("info@kfc.com");
        merchant.setTelepon("16000");
        merchant.setAlamat("Margonda, Depok, Jawa Barat, Indonesia (16426)");
        merchant.setKeterangan("Sahabat setia menemani setiap hari Anda bersama keluarga, teman, rekan kerja dan orang tersayang.");
        merchants.add(merchant);

        merchant    = new Merchant();
        merchant.setNama("MCD Margonda Residence");
        merchant.setEmail("info@mcd.com");
        merchant.setTelepon("16000");
        merchant.setAlamat("Margonda, Depok, Jawa Barat, Indonesia (16426)");
        merchant.setKeterangan("Sahabat setia menemani setiap hari Anda bersama keluarga, teman, rekan kerja dan orang tersayang.");
        merchants.add(merchant);

        merchant    = new Merchant();
        merchant.setNama("Gerilona Margonda Residence");
        merchant.setEmail("info@gerilona.com");
        merchant.setTelepon("16000");
        merchant.setAlamat("Margonda, Depok, Jawa Barat, Indonesia (16426)");
        merchant.setKeterangan("Sahabat setia menemani setiap hari Anda bersama keluarga, teman, rekan kerja dan orang tersayang.");
        merchants.add(merchant);

        return merchants;
    }

}
