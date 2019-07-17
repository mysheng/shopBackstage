package com.mysheng.office.intercept;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mysheng.office.base.Results;
import com.mysheng.office.base.SystemCache;
import com.mysheng.office.enums.ResultError;
import com.mysheng.office.exception.CustomException;
import com.mysheng.office.model.Result;
import com.mysheng.office.util.JsonUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 接口业务拦截器
 */
@Component
public class AppInterceptor extends HandlerInterceptorAdapter {
	/**
	 * 业务不需要拦截的方法正则
	 */
	public static final String NO_INTERCEPTOR = ".*/((user/*)|(home/index)|(classify/list)).*";
	
	
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		response.setContentType("text/html;charset=utf-8");
//		if(2>1){
//			return true;
//		}
		String path = request.getServletPath();
		//过滤不需要拦截的
		if(path.matches(NO_INTERCEPTOR) ){
			return true;
		}else{//需要拦截的
			String token=request.getHeader("token");//用户登录标识
			if(null == token || "".equals(token)){
//				Result result=new Result(401,"请您登陆",null);
//				JSONObject jsonObj = (JSONObject) JSON.toJSON(result);
//				JSON json = (JSON) JSON.toJSON(result);
//				response.getWriter().print(jsonObj);
//				response.getWriter().close();
//				return false;
				throw  new CustomException(ResultError.LOGIN_INFO);
			}

			return true;
		}
		
	}
}
