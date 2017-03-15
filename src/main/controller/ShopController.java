package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Popup;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ShopController implements Initializable {

    @FXML
    private TextField search;
    @FXML
    private ToggleButton reception, company, promotions, products, news, team;
    @FXML
    private AnchorPane center;
    private Shop shop;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.shop = this.createData();

        ToggleGroup group = new ToggleGroup();

        this.reception.setToggleGroup(group);
        this.company.setToggleGroup(group);
        this.products.setToggleGroup(group);
        this.promotions.setToggleGroup(group);
        this.news.setToggleGroup(group);
        this.team.setToggleGroup(group);

        this.reception.fire();
        this.actionReception();

    }

    public void actionReception() {

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/Accueil.fxml"));
            Parent pane = loader.load();
            ((ReceptionController) loader.getController()).init(this.shop.getInfo());

            if (this.center.getChildren().size() == 0)
                this.center.getChildren().add(pane);
            else
                this.center.getChildren().set(0, pane);

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    public void actionSales() {

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/Produit.fxml"));
            Parent pane = loader.load();
            ((ProductController) loader.getController()).init(this.shop.getInventory(), "PROMOTIONS");
            this.center.getChildren().set(0, pane);

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    public void actionProducts() {

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/Produit.fxml"));
            Parent pane = loader.load();
            ((ProductController) loader.getController()).init(this.shop.getInventory(), "CATEGORIES");
            this.center.getChildren().set(0, pane);

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public void actionNews() {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/Produit.fxml"));
            Parent pane = loader.load();
            ((ProductController) loader.getController()).init(this.shop.getInventory(), "NOUVEAUTES");
            this.center.getChildren().set(0, pane);

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public void actionCompany() {
        //Todo rebalancer le gens sur la page de l'enseigne
    }

    public void actionTeam() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/Equipe.fxml"));
            Parent pane = loader.load();
            ((TeamController) loader.getController()).initEmployee(this.shop.getTeam());
            this.center.getChildren().set(0, pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void keyListenerAdmin(KeyEvent event) {
        try {

            if (event.getEventType() == KeyEvent.KEY_PRESSED && event.getCode() == KeyCode.A) {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("view/admin/admin.fxml"));
                Parent pane = loader.load();
                ((AdminController) loader.getController()).init(this.shop);

                Popup admin = new Popup();
                pane.setOnKeyPressed(e -> {
                    if (e.getCode() == KeyCode.Q)
                        admin.hide();
                });

                admin.getContent().add(pane);
                admin.setY(50);
                admin.setX(50);
                admin.show(this.center.getScene().getWindow());

            }
        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    private Shop createData() {
        Information info = new Information("21", "tbth", "Lun.", "Sam.",
                "8h", "30", "20h", "00", "Fermeture exceptionnelle le 14/03/17!", "Bienvenue! Ouverts 6j/7 et entre midi et deux, nous vous\npermettons de venir retirer vos commandes faites par\ninternet pendant votre pause! Venez nous voir munis\nde votre bon de commande et gagnez du temps!\nNotre équipe espère vous voir bientôt!", "En face des escaliers", "2");

        List<Employee> workers = Arrays.asList(
                new Employee("Maurice", "Lopez", "Directeur", "image/directeur.png"),
                new Employee("Maurice", "Lopez", "Directeur", "image/directeur.png"),
                new Employee("Maurice", "Lopez", "Directeur", "image/directeur.png"),
                new Employee("Philip", "Moris", "Vendeur", "image/vendeur.jpg"),
                new Employee("Philip", "Moris", "Vendeur", "image/vendeur.jpg"),
                new Employee("Philip", "Moris", "Vendeur", "image/vendeur.jpg"),
                new Employee("Florian", "Guillaume", "Conseiller", "image/conseiller.png")
        );

        List<List<Product>> products = Arrays.asList(
                Arrays.asList(
                        new Product("produit1", "produit/produit1.jpg", "Ce produit est un produit qui est bien !", 25, true),
                        new Product("produit1", "produit/produit1.jpg", "Ce produit est un produit qui est bien !", 25, true),
                        new Product("produit1", "produit/produit1.jpg", "Ce produit est un produit qui est bien !", 25, true),
                        new Product("produit1", "produit/produit1.jpg", "Ce produit est un produit qui est bien !", 25, true),
                        new Product("produit1", "produit/produit1.jpg", "Ce produit est un produit qui est bien !", 25, true),
                        new Product("produit1", "produit/produit1.jpg", "Ce produit est un produit qui est bien !", 25, true),
                        new Product("produit1", "produit/produit1.jpg", "Ce produit est un produit qui est bien !", 25, true)

                ),
                Arrays.asList(
                        new Product("produit26", "produit/produit2.jpg", "Ce produit est un produit qui est cher mais qui est bien, il est quand même relativement cher !", 250, false),
                        new Product("produit2", "produit/produit2.jpg", "Ce produit est un produit qui est cher !", 250, true),
                        new Product("produit2", "produit/produit2.jpg", "Ce produit est un produit qui est cher !", 250, true)
                ),
                Arrays.asList(
                        new Product("produit3", "produit/produit3.jpg", "Ce produit est un produit !", 250, false),
                        new Product("produit3", "produit/produit3.jpg", "Ce produit est un produit !", 250, true),
                        new Product("produit3", "produit/produit3.jpg", "Ce produit est un produit !", 2500, false)
                ),
                Arrays.asList(
                        new Product("produit1", "produit/produit1.jpg", "Ce produit est un produit !", 250, true),
                        new Product("produit2", "produit/produit2.jpg", "Ce produit est un produit !", 250, true),
                        new Product("produit3", "produit/produit3.jpg", "Ce produit est un produit !", 2500, false)
                )
        );

        Map<String, List<Product>> map = new HashMap<>();

        for (int i = 0; i < products.size(); i++)
            map.put("Categorie " + i, products.get(i));

        Inventory inventory = new Inventory(map);

        return new Shop(info, workers, inventory);
    }

    public void searchCall() {

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/Produit.fxml"));
            Parent pane = loader.load();
            ((ProductController) loader.getController()).init(this.shop.getInventory(), this.search.getText().toUpperCase());
            this.center.getChildren().set(0, pane);

        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}
