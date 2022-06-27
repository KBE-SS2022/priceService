package priceService.api.beanmaker;

import org.json.JSONObject;

public class PriceServiceBean {

    private JSONObject jsonObject;

    public PriceServiceBean() {}

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }
}
