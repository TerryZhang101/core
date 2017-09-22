package com.nms.core.interceptor;

import com.nms.core.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * HTTP拦截器
 * Created by K on 2017/9/20.
 */
public class HTTPRequestLoggerInterceptor extends HandlerInterceptorAdapter {

    private static final ThreadLocal<Long> startTimeThreadLocal =
            new NamedThreadLocal<Long>("ThreadLocal StartTime");

    private static final Logger logger = LoggerFactory.getLogger(HTTPRequestLoggerInterceptor.class);

    private static ExecutorService pool = Executors.newFixedThreadPool(5);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Long beginTime = System.currentTimeMillis();//1、开始时间
        startTimeThreadLocal.set(beginTime);		//线程绑定变量（该数据只有当前请求的线程可见）
        logger.debug("开始计时: {}  URI: {}", new SimpleDateFormat("hh:mm:ss.SSS")
                .format(beginTime), request.getRequestURI());

        request.setAttribute("DBLOG.LOGBEGTIME", new Date());
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        if (modelAndView != null){
            logger.info("ViewName: " + modelAndView.getViewName());
        }

        Map<String, String> DBLog = new HashMap<String, String>();
        //TODO 数据库日志记录

        /*Date startTime = (Date)request.getAttribute("DBLOG.LOGBEGTIME");
        DBLog.put("NCL_LOGBEGTIME", DateUtil.getFormatDate(startTime, "yyyyMMddHHmmss"));

        Date endTime = new Date();
        DBLog.put("NCL_LOGTIME", DateUtil.getFormatDate(endTime, "yyyyMMddHHmmss"));
        DBLog.put("NCL_LOGENDTIME", DateUtil.getFormatDate(endTime, "yyyyMMddHHmmss"));

        //记录到数据库日志中
        Map<String, String> respMap = (Map<String, String>)request.getAttribute("DBLOG.TRANRESP");

        //商户号
        String merCode = request.getParameter("merId");
        if(merCode == null){
            merCode = respMap.get("merId");
        }
        DBLog.put("NCL_CSTNO", merCode);

        String cardNo = request.getParameter("accNo");
        DBLog.put("NCL_CARDNO", StringUtil.nvl(cardNo));

        String proNo = request.getParameter("proNo");
        DBLog.put("NCL_PRONO", proNo);

        DBLog.put("NCL_TRANCOD", request.getParameter("tranType"));
        DBLog.put("NCL_IP", request.getRemoteAddr());
        DBLog.put("NCL_BANKCODE","");
        DBLog.put("NCL_LOG1","");
        DBLog.put("NCL_LOG3","");

        DBLog.put("NCL_OPRRLT", StringUtil.nvl(respMap.get("tranResult")));

        StringBuilder sb = new StringBuilder();
        for(String key : request.getParameterMap().keySet()){
            sb.append(key + "=" + request.getParameter(key) + "\r\n");
        }
        DBLog.put("NCL_LOG2", sb.toString());

        sb = new StringBuilder();
        for(String key : respMap.keySet()){
            sb.append(key + "=" + respMap.get(key) + "\r\n");
        }
        DBLog.put("NCL_LOG4", sb.toString());

        String logNo = DateUtil.getCurrentTime("yyMMddHHmmss");
        DBLog.put("NCL_LOGNO", MsgUtil.getShortMsgId());*/

        //System.out.println("RequestDBLogger postHandle");
        //System.out.println(DBLog.toString());

        AysnDBRecorder dbRecorder = new AysnDBRecorder(DBLog);
        pool.execute(dbRecorder);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {

        // 打印JVM信息。
        if (logger.isDebugEnabled()){
            long beginTime = startTimeThreadLocal.get();//得到线程绑定的局部变量（开始时间）
            long endTime = System.currentTimeMillis(); 	//2、结束时间
            logger.debug("计时结束：{}  耗时：{}  URI: {}  最大内存: {}m  已分配内存: {}m  已分配内存中的剩余空间: {}m  最大可用内存: {}m",
                    new SimpleDateFormat("hh:mm:ss.SSS").format(endTime), DateUtil.formatDateTime(endTime - beginTime),
                    request.getRequestURI(), Runtime.getRuntime().maxMemory()/1024/1024, Runtime.getRuntime().totalMemory()/1024/1024, Runtime.getRuntime().freeMemory()/1024/1024,
                    (Runtime.getRuntime().maxMemory()-Runtime.getRuntime().totalMemory()+Runtime.getRuntime().freeMemory())/1024/1024);
            //删除线程变量中的数据，防止内存泄漏
            startTimeThreadLocal.remove();
        }

    }
}
