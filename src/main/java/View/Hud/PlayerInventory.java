package View.Hud;

import Model.Object.ObjectManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class PlayerInventory {
    /*
        Francesco: ho provato a rendere l'inventario funzionale, con il numero di monete raccolte rappresentano nell'inventario, ma
        purtropp non ci sono riuscito in quanto il numero di monete e all' interno dell'istanza item nella classe ObjectManager.
        Ciò significa che dovrei in qualche modo passare item da Objectmanager a Hud per poi finire su PlayerInventory. Urge quindi
        l'implementazione del pattern Observer.



     */

    private Stage stage;
    private Model.Object.Item item;
    private FitViewport stageViewport;
    private ObjectManager objectManager ;
    private final float SCALE = 0.2f;

    private Table table;
    private Label labelCoin;
    private Label labelKey;
    private Label labelMoney;
    private Label labelMeat;
    private Label labelDiamond;

    //objects counters
    private int coinValue;
    private int keyValue;
    private int moneyValue;
    private int meatValue;
    private int diamondValue;
    public PlayerInventory(ObjectManager objectManager){
        //item = new Item();
        //stageViewport = new FitViewport(Boot.INSTANCE.getScreenWidth()/2,Boot.INSTANCE.getScreenHeight()/2);
        //stage = new Stage(stageViewport,batch);

        this.objectManager = objectManager;
        table = new Table();
        table.right().top();
        table.setFillParent(true);

        coinValue = Integer.parseInt(objectManager.getItem().getCoin());
        keyValue = Integer.parseInt(objectManager.getItem().getKey());
        moneyValue = Integer.parseInt(objectManager.getItem().getMoney());
        meatValue = Integer.parseInt(objectManager.getItem().getMeat());
        diamondValue = Integer.parseInt(objectManager.getItem().getDiamond());

        Texture image1 = new Texture(Gdx.files.internal("inventory/key/key_A_gold.png"));
        Image icon1 = new Image(image1);
        icon1.setSize(image1.getWidth()*SCALE, image1.getHeight()*SCALE);

        Texture image2 = new Texture(Gdx.files.internal("inventory/coin/coin.png"));
        Image icon2 = new Image(image2);
        icon2.setSize(image2.getWidth()*SCALE, image2.getHeight()*SCALE);

        Texture image3 = new Texture(Gdx.files.internal("inventory/money/money.png"));
        Image icon3 = new Image(image3);
        icon3.setSize(image3.getWidth()*SCALE, image3.getHeight()*SCALE);

        Texture image4 = new Texture(Gdx.files.internal("inventory/meat/meat.png"));
        Image icon4 = new Image(image4);
        icon4.setSize(image4.getWidth()*SCALE, image4.getHeight()*SCALE);

        Texture image5 = new Texture(Gdx.files.internal("inventory/diamond/diamond.png"));
        Image icon5 = new Image(image5);
        icon5.setSize(image5.getWidth()*0.1f, image5.getHeight()*SCALE);

        labelCoin = new Label(String.format("%01d",coinValue),new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        labelKey = new Label(String.format("%01d",keyValue),new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        labelMoney = new Label(String.format("%01d",moneyValue),new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        labelMeat = new Label(String.format("%01d",meatValue),new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        labelDiamond = new Label(String.format("%01d",diamondValue),new Label.LabelStyle(new BitmapFont(), Color.WHITE));


        table.setFillParent(true);
        table.add(icon1).padRight(5);
        table.add(labelKey).padRight(5);
        table.add(icon2).padRight(5);
        table.add(labelCoin).padRight(5);
        table.add(icon3).padRight(5);
        table.add(labelMoney).padRight(5);
        table.add(icon4).padRight(5);
        table.add(labelMeat).padRight(5);
        table.add(icon5).padRight(5);
        table.add(labelDiamond);

        table.setVisible(false);

    }

    public Table getTable() {
        return table;
    }

    public void visibilitySwitch(){
        boolean visible = this.table.isVisible();
        if (visible) {
            this.table.setVisible(false);
        } else if (!(visible)) {
            this.table.setVisible(true);
        }
    }



    public void update(){
        //coinValue = item.getCoin();
        coinValue = Integer.parseInt(objectManager.getItem().getCoin());
        labelCoin.setText(String.format("%01d", coinValue));

        keyValue = Integer.parseInt(objectManager.getItem().getKey());
        labelKey.setText(String.format("%01d", keyValue));

        moneyValue = Integer.parseInt(objectManager.getItem().getMoney());
        labelMoney.setText(String.format("%01d", moneyValue));

        meatValue = Integer.parseInt(objectManager.getItem().getMeat());
        labelMeat.setText(String.format("%01d", meatValue));

        diamondValue = Integer.parseInt(objectManager.getItem().getDiamond());
        labelDiamond.setText(String.format("%01d", diamondValue));
    }

}
