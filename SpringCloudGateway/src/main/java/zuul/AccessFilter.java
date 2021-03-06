package zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

public class AccessFilter extends ZuulFilter {
    @Override
//    过滤器的类型，它决定过滤器在请求的哪个生命周期中执行。这里定义为pre,代表会在请求被路由之前执行。
    public String filterType() {
        return "pre";
    }

    @Override
//    过滤器的执行顺序。当请求在一个阶段中存在多个过滤器时，需要根据该方法返回的值来依次执行。
    public int filterOrder() {
        return 0;
    }

    @Override
//    判断该过滤器是否需要被执行。这里我们直接返回了true,因此该过滤器对所有请求都会生效。实际运用中我们可以利用该函数来指定过滤器的有效范围。
    public boolean shouldFilter() {
        return true;
    }

    @Override
//    过滤器的具体逻辑。
//    这里我们通过ctx.setSendZuulResponse(false)令zuul过滤该请求，不对其进行路由，然后通过ctx.setResponseStatusCode(401)设置了其返回的错误码，
//    当然也可以进 一步优化我们的返回，比如，通过ctx.setResponseBody(body)对返回的body内容进行编辑等。
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.out.println("send {} request to{}"+request.getMethod()+request.getRequestURL().toString());
        Object accessToken = request.getParameter("accessToken");
        if (accessToken == null) {
            System.out.println("accessToken is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("accessToken is empty");
            } catch (Exception e) {
            }
            return null;
        }
        System.out.println("access is ok");
        return null;
    }
}
