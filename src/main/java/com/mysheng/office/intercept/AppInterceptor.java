package com.mysheng.office.intercept;

import com.mysheng.office.base.Results;
import com.mysheng.office.base.SystemCache;
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
	public static final String NO_INTERCEPTOR = ".*/((user/login)|(user/register)|(home/index)).*";
	
	
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
			String token=request.getParameter("token");//用户登录标识
			if(null == token || "".equals(token)){
				Results resultAppDto = new Results();
				resultAppDto.setStatus(Results.FAILURE);
				resultAppDto.setErrorCode("200201");
				resultAppDto.setErrorMsg("用户信息错误");
				String jsonToString = JsonUtil.JsonToString(resultAppDto);
				response.getWriter().print(jsonToString);
				response.getWriter().close();
				return false;
			}
			//验证用户登录信息持否正确
			String string = SystemCache.USER_TOKEN_MAP.get(token);
			if(null == string || "".equals(token)){//c值错误
				Results resultAppDto = new Results();
				resultAppDto.setStatus(Results.FAILURE);
				resultAppDto.setErrorCode("200201");
				resultAppDto.setErrorMsg("用户信息错误");
				String jsonToString = JsonUtil.JsonToString(resultAppDto);
				response.getWriter().print(jsonToString);
				response.getWriter().close();
				return false;
			}
			return true;
		}
		
	}
}
