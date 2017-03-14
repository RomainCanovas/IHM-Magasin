package controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import model.Information;
import model.Shop;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class AdminAccesController implements Initializable {

    @FXML
    ToggleButton tb1, tb2, tb0;
	@FXML
	TextField clue;
	@FXML
	AnchorPane center;

	private Information info;
	private Shop shop;

    private int floor;

    public void init(Information info) {
        this.info = info;
        floor=info.getFloor();
        clue.setText(this.info.getClue());
        final ToggleGroup group = new ToggleGroup();
        tb1.setToggleGroup(group);
        tb2.setToggleGroup(group);
        tb0.setToggleGroup(group);
        switch (floor){
            case 0:
                tb0.setSelected(true);
                break;
            case 1:
                tb1.setSelected(true);
                break;
            case 2:
                tb2.setSelected(true);
                break;
            default:
                break;
        }
    }
	public void init(Shop s) {
		this.info = s.getInfo();
		this.shop = s;
		clue.setText(this.info.getClue());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

    public void giveFloor0() {
        this.floor=0;
    }

    public void giveFloor1() {
        this.floor=1;
    }

    public void giveFloor2() {
        this.floor=2;
    }

	public void setFloor0() {
		this.info.setFloor(0);
	}

	public void setFloor1() {
		this.info.setFloor(1);
	}

	public void setFloor2() {
		this.info.setFloor(2);
	}

	public void setModifiedClue() {
		this.info.setClue(clue.getText());
	}

    public void validChanges(){
        setModifiedClue();
        switch(floor){
            case 0:
                setFloor0();
                break;
            case 1:
                setFloor1();
                break;
            case 2:
                setFloor2();
                break;
            default:
                break;
        }
    }

	public void actionAdmin() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/admin/admin.fxml"));
			Parent pane = loader.load();
			((AdminController) loader.getController()).init(this.shop);
			this.center.getChildren().set(0, pane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
