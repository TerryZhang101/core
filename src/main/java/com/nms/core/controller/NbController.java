package com.nms.core.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.nms.core.enums.ErrorCodeEnum;
import com.nms.core.exception.CoreException;
import com.nms.core.service.NbService;
import com.nms.core.util.ParamCheckUtil;
import com.nms.core.util.ResponseFormatUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 诺宝Controller
 * Created by K on 2017/9/21.
 */

@RestController
@RequestMapping(value = "/acc/nb")
public class NbController {

    private static final Logger logger = LoggerFactory.getLogger(NbController.class);

    @Autowired
    NbService nbService;

    @RequestMapping(value = "/create_nb_order_prepay")
    public Map<String,Object> create_nb_order_prepay(@RequestBody JSONObject jsonObj, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info(request.getRequestURI() + " ==> " + JSON.toJSONString(jsonObj));

        Map<String,Object> responseMap = new HashMap<String,Object>();
        String[] requiredFields = {"cust_no","pay_amount","pay_type","biz_type","organ_id","channel"};

        try {

            if(ParamCheckUtil.isEmpty(jsonObj,requiredFields)){
                throw new CoreException(ErrorCodeEnum.PARAMEMPTY);
            }

            nbService.create_nb_order_prepay(jsonObj,responseMap);
            responseMap = ResponseFormatUtil.formatResponse(responseMap);

        }catch (CoreException e) {
            responseMap = ResponseFormatUtil.formatResponseError(e.getEce());
        } catch (Exception e) {
            logger.error("诺宝充值生成支付订单异常",e);
            responseMap = ResponseFormatUtil.formatResponseError(ErrorCodeEnum.INTERERROR);
        }

        String responseJson = JSON.toJSONString(responseMap, SerializerFeature.MapSortField);
        logger.info(request.getRequestURI() + " <== " + responseJson);

        return responseMap;

    }

    @RequestMapping(value = "/notify_nb_order_payed_result")
    public Map<String,Object> notify_nb_order_payed_result(@RequestBody JSONObject jsonObj, HttpServletRequest request, HttpServletResponse response) throws Exception{
        logger.info(request.getRequestURI() + " ==> " + JSON.toJSONString(jsonObj));

        Map<String,Object> responseMap = new HashMap<String,Object>();
        String[] requiredFields = {"cust_no","pay_amount","pay_type","prepay_id","pay_id","pay_result","biz_type","organ_id","channel"};

        try {

            if(ParamCheckUtil.isEmpty(jsonObj,requiredFields)){
                throw new CoreException(ErrorCodeEnum.PARAMEMPTY);
            }

            nbService.notify_nb_order_payed_result(jsonObj);
            responseMap = ResponseFormatUtil.formatResponse(responseMap);

        }catch (CoreException e) {
            responseMap = ResponseFormatUtil.formatResponseError(e.getEce());
        } catch (Exception e) {
            logger.error("诺宝充值支付结果通知异常",e);
            responseMap = ResponseFormatUtil.formatResponseError(ErrorCodeEnum.INTERERROR);
        }

        String responseJson = JSON.toJSONString(responseMap, SerializerFeature.MapSortField);
        logger.info(request.getRequestURI() + " <== " + responseJson);

        return responseMap;

    }

    @RequestMapping(value = "/nb_withdraw_apply")
    public Map<String,Object> nb_withdraw_apply(@RequestBody JSONObject jsonObj, HttpServletRequest request, HttpServletResponse response) throws Exception{
        logger.info(request.getRequestURI() + " ==> " + JSON.toJSONString(jsonObj));

        Map<String,Object> responseMap = new HashMap<String,Object>();
        String[] requiredFields = {"cust_no","biz_type","pay_type","withdraw_amount","card_no","tran_pwd","organ_id","channel"};

        try {

            if(ParamCheckUtil.isEmpty(jsonObj,requiredFields)){
                throw new CoreException(ErrorCodeEnum.PARAMEMPTY);
            }

            nbService.nb_withdraw_apply(jsonObj);
            responseMap = ResponseFormatUtil.formatResponse(responseMap);

        }catch (CoreException e) {
            responseMap = ResponseFormatUtil.formatResponseError(e.getEce());
        } catch (Exception e) {
            logger.error("诺宝提现申请异常",e);
            responseMap = ResponseFormatUtil.formatResponseError(ErrorCodeEnum.INTERERROR);
        }

        String responseJson = JSON.toJSONString(responseMap, SerializerFeature.MapSortField);
        logger.info(request.getRequestURI() + " <== " + responseJson);

        return responseMap;

    }

    @RequestMapping(value = "/nb_withdraw_feerate_qry")
    public Map<String,Object> nb_withdraw_feerate_qry(@RequestBody JSONObject jsonObj, HttpServletRequest request, HttpServletResponse response) throws Exception{
        logger.info(request.getRequestURI() + " ==> " + JSON.toJSONString(jsonObj));

        Map<String,Object> responseMap = new HashMap<String,Object>();
        String[] requiredFields = {"cust_no","biz_type","organ_id","channel"};

        try {

            if(ParamCheckUtil.isEmpty(jsonObj,requiredFields)){
                throw new CoreException(ErrorCodeEnum.PARAMEMPTY);
            }

            nbService.nb_withdraw_feerate_qry(jsonObj,responseMap);
            responseMap = ResponseFormatUtil.formatResponse(responseMap);

        }catch (CoreException e) {
            responseMap = ResponseFormatUtil.formatResponseError(e.getEce());
        } catch (Exception e) {
            logger.error("诺宝提现税率查询异常",e);
            responseMap = ResponseFormatUtil.formatResponseError(ErrorCodeEnum.INTERERROR);
        }

        String responseJson = JSON.toJSONString(responseMap, SerializerFeature.MapSortField);
        logger.info(request.getRequestURI() + " <== " + responseJson);

        return responseMap;

    }

    @RequestMapping(value = "/nb_withdraw_card_qry")
    public Map<String,Object> nb_withdraw_card_qry(@RequestBody JSONObject jsonObj, HttpServletRequest request, HttpServletResponse response) throws Exception{
        logger.info(request.getRequestURI() + " ==> " + JSON.toJSONString(jsonObj));

        Map<String,Object> responseMap = new HashMap<String,Object>();
        String[] requiredFields = {"cust_no","organ_id","channel"};

        try {

            if(ParamCheckUtil.isEmpty(jsonObj,requiredFields)){
                throw new CoreException(ErrorCodeEnum.PARAMEMPTY);
            }

            nbService.nb_withdraw_card_qry(jsonObj,responseMap);
            responseMap = ResponseFormatUtil.formatResponse(responseMap);

        }catch (CoreException e) {
            responseMap = ResponseFormatUtil.formatResponseError(e.getEce());
        } catch (Exception e) {
            logger.error("诺宝提现银行卡查询异常",e);
            responseMap = ResponseFormatUtil.formatResponseError(ErrorCodeEnum.INTERERROR);
        }

        String responseJson = JSON.toJSONString(responseMap, SerializerFeature.MapSortField);
        logger.info(request.getRequestURI() + " <== " + responseJson);

        return responseMap;

    }

    @RequestMapping(value = "/nb_partner_qry")
    public Map<String,Object> nb_partner_qry(@RequestBody JSONObject jsonObj, HttpServletRequest request, HttpServletResponse response) throws Exception{
        logger.info(request.getRequestURI() + " ==> " + JSON.toJSONString(jsonObj));

        Map<String,Object> responseMap = new HashMap<String,Object>();
        String[] requiredFields = {"cust_no","biz_type","organ_id","channel"};

        try {

            if(ParamCheckUtil.isEmpty(jsonObj,requiredFields)){
                throw new CoreException(ErrorCodeEnum.PARAMEMPTY);
            }

            nbService.nb_partner_qry(jsonObj,responseMap);
            responseMap = ResponseFormatUtil.formatResponse(responseMap);

        }catch (CoreException e) {
            responseMap = ResponseFormatUtil.formatResponseError(e.getEce());
        } catch (Exception e) {
            logger.error("诺宝往来伙伴查询异常",e);
            responseMap = ResponseFormatUtil.formatResponseError(ErrorCodeEnum.INTERERROR);
        }

        String responseJson = JSON.toJSONString(responseMap, SerializerFeature.MapSortField);
        logger.info(request.getRequestURI() + " <== " + responseJson);

        return responseMap;

    }

    @RequestMapping(value = "/nb_transfer")
    public Map<String,Object> nb_transfer(@RequestBody JSONObject jsonObj, HttpServletRequest request, HttpServletResponse response) throws Exception{
        logger.info(request.getRequestURI() + " ==> " + JSON.toJSONString(jsonObj));

        Map<String,Object> responseMap = new HashMap<String,Object>();
        String[] requiredFields = {"cust_no","biz_type","tran_amount","recv_acc_no","recv_cust_name","tran_pwd","tran_date","organ_id","channel"};

        try {

            if(ParamCheckUtil.isEmpty(jsonObj,requiredFields)){
                throw new CoreException(ErrorCodeEnum.PARAMEMPTY);
            }

            nbService.nb_transfer(jsonObj);
            responseMap = ResponseFormatUtil.formatResponse(responseMap);

        }catch (CoreException e) {
            responseMap = ResponseFormatUtil.formatResponseError(e.getEce());
        } catch (Exception e) {
            logger.error("诺宝转账异常",e);
            responseMap = ResponseFormatUtil.formatResponseError(ErrorCodeEnum.INTERERROR);
        }

        String responseJson = JSON.toJSONString(responseMap, SerializerFeature.MapSortField);
        logger.info(request.getRequestURI() + " <== " + responseJson);

        return responseMap;

    }

    @RequestMapping(value = "/nb_detail_qry")
    public Map<String,Object> nb_detail_qry(@RequestBody JSONObject jsonObj, HttpServletRequest request, HttpServletResponse response) throws Exception{

        logger.info(request.getRequestURI() + " ==> " + JSON.toJSONString(jsonObj));

        Map<String,Object> responseMap = new HashMap<String,Object>();
        String[] requiredFields = {"cust_no","biz_type","begin_date","end_date","per_page_show","begin_pos","organ_id","channel"};

        try {

            if(ParamCheckUtil.isEmpty(jsonObj,requiredFields)){
                throw new CoreException(ErrorCodeEnum.PARAMEMPTY);
            }

            nbService.nb_detail_qry(jsonObj,responseMap);
            responseMap = ResponseFormatUtil.formatResponse(responseMap);

        }catch (CoreException e) {
            responseMap = ResponseFormatUtil.formatResponseError(e.getEce());
        } catch (Exception e) {
            logger.error("诺宝明细异常",e);
            responseMap = ResponseFormatUtil.formatResponseError(ErrorCodeEnum.INTERERROR);
        }

        String responseJson = JSON.toJSONString(responseMap, SerializerFeature.MapSortField);
        logger.info(request.getRequestURI() + " <== " + responseJson);

        return responseMap;

    }
}
