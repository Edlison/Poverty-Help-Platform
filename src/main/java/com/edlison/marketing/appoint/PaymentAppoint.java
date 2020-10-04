package com.edlison.marketing.appoint;

import com.alibaba.fastjson.JSONObject;
import com.edlison.marketing.DTO.PayDTO;
import com.edlison.marketing.DTO.QueryOrderDTO;
import com.edlison.marketing.DTO.UnifiedOrderDTO;
import com.edlison.marketing.result.SystemResult;
import io.netty.handler.codec.http.HttpConstants;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * PaymentAppoint
 *
 * @Author Edlison
 * @Date 8/14/20 00:21
 */
@Component
public class PaymentAppoint {

    @Value("${UNIFIEDORDER}")
    private String UNIFIEDORDER;

    @Value("${ORDERQUERY}")
    private String ORDERQUERY;

    public SystemResult toXML(PayDTO o) {
        if (o instanceof UnifiedOrderDTO) {
            UnifiedOrderDTO order = ((UnifiedOrderDTO) o);
            System.out.println(order);

            try {
                Document document = DocumentHelper.createDocument();
                Element root = document.addElement("xml");
                Element appid = root.addElement("appid").addText(order.getAppid());
                Element mch_id = root.addElement("mch_id").addText(order.getMch_id());
                Element nonce_str = root.addElement("nonce_str").addText(order.getNonce_str());
                Element sign = root.addElement("sign").addText(order.getSign());
                Element body = root.addElement("body").addText(order.getBody());
                Element openid = root.addElement("openid").addText(order.getOpenid());
                Element out_trade_no = root.addElement("out_trade_no").addText(order.getOut_trade_no());
                Element total_fee = root.addElement("total_fee").addText(order.getTotal_fee().toString());
                Element spbill_create_ip = root.addElement("spbill_create_ip").addText(order.getSpbill_create_ip());
                Element notify_url = root.addElement("notify_url").addText(order.getNotify_url());
                Element trade_type = root.addElement("trade_type").addText(order.getTrade_type());

                System.out.println(document.asXML());

                SystemResult res = SystemResult.PLACE_ORDER_SUCCESS;
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("xml", document.asXML());
                res.setData(jsonObject);

                return res;
            } catch (Exception e) {
                return SystemResult.PLACE_ORDER_FAILED;
            }

        } else if (o instanceof QueryOrderDTO) {
            QueryOrderDTO order = ((QueryOrderDTO) o);
            System.out.println(order);

            try {

                return SystemResult.QUERY_ORDER_SUCCESS;
            } catch (Exception e) {

                return SystemResult.QUERY_ORDER_FAILED;
            }

        } else {

            return SystemResult.PAYMENT_FAILED;
        }

    }

    public SystemResult queryOrder() {

        return null;
    }

    public SystemResult postXML(String content) throws Exception{

        CloseableHttpClient httpClient = HttpClients.createDefault();

        String url = UNIFIEDORDER;  // null

        System.out.println("url = " + url);

        HttpPost post = new HttpPost(url);
        post.setHeader("Content-Type","text/xml");
        post.setHeader("charset","utf-8");
        StringEntity stringEntity = new StringEntity(content, "utf-8");
        stringEntity.setContentEncoding("utf-8");
        stringEntity.setContentType("text/xml");
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        HttpEntity entity = response.getEntity();
        String res = EntityUtils.toString(entity, "utf-8");
        System.out.println(res);

        // TODO 解析XML 需要对CDATA进行处理
//        SAXReader saxReader = new SAXReader();
//        Document document = saxReader.read(res);
//        Element xml = document.getRootElement();
//
//        List<Element> prepay_id = xml.elements("prepay_id");
//        String text = prepay_id.get(0).getText();
//        System.out.println("text = " + text);

        if (res != null) {
            SystemResult postXmlSuccess = SystemResult.POST_XML_SUCCESS;
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("res", res);
            postXmlSuccess.setData(jsonObject);

            return postXmlSuccess;
        }
        else return SystemResult.POST_XML_FAILED;
    }
}
