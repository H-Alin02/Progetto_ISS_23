package Model.Object;

import com.badlogic.gdx.utils.Array;

public class Item {
    private Array<Coin> coin;
    private Array<Diamond> diamond;
    private Array<Money> money;
    private Array<Meat> meat;
    private Array<Key> key;

    public Item(){
        this.coin = new Array<>();
        this.diamond = new Array<>();
        this.money = new Array<>();
        this.meat = new Array<>();
        this.key = new Array<>();
    }

    public void addCoin(ObjectGame obj){
        coin.add((Coin) obj);
        System.out.println("coin " + coin.size);
    }

    public void addDiamond(ObjectGame obj){
        diamond.add((Diamond) obj);
        System.out.println("diamond "+ diamond.size);
    }

    public void addMoney(ObjectGame obj){
        money.add((Money) obj);
        System.out.println("money " + money.size);
    }

    public void addMeat(ObjectGame obj){
        meat.add((Meat) obj);
        System.out.println("meat " + meat.size);
    }

    public void addKey(ObjectGame obj){
        key.add((Key) obj);
        System.out.println("key " + key.size);
    }


    public String getCoin() {
        return String.valueOf(coin.size);
    }

    public String getDiamond() {
        return String.valueOf(diamond.size);
    }

    public String getMoney() {
        return String.valueOf(money.size);
    }

    public String getMeat() {
        return String.valueOf(meat.size);
    }

    public String getKey() {
        return String.valueOf(key.size);
    }

    public void update(float delta){
        getCoin();
        getKey();
        getMeat();
        getMoney();
        getDiamond();
    }
}
