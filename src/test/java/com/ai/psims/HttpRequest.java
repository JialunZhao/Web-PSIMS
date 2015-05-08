package com.ai.psims;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;


public class HttpRequest {
    /**
     * 向指定URL发送GET方法的请求
     * 
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("Accept", "*/*");
            conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
            conn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
            conn.setRequestProperty("Content-Length", "208");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
//            conn.setRequestProperty("Cookie", "*/*");
            conn.setRequestProperty("Cookie", "testcookie=testvalue; JSESSIONID=8791B1D05C11BC18AF7DBBAC87D7C5A3; firstEnterUrlInSession=http%3A//www.ikongjian.com/index.html; baidu_qiao_v3_count_6087028=1; VisitorCapacity=1; uid="+"MTY4NDk="+"; uname="+"MTM5MDExNjczNDM="+"; pageReferrInSession=https%3A//www.baidu.com/baidu.php%3Fsc.Kf0000jz6UxuAENyjv4eix1fno5D00EakBWls9PpRPlqEoxYRU5sIbhyyvLNkSR8tcL9-kTC0beKhmlgYU8Xob3JwUY0-9WBqqssv1MRrNTU0S2rzEudRvK5JqfJsyK1s5dRkjs.DD_KOpeP-X1D9i_nYQZu8lIh4f.U1YY0ZDqY2ZjdzRznQ1ide00IjLfCT5gFHcsEPQg_0KGUHYznWR0u1dBuZCs0ZNG5yF9pywd0ZKGujYk0APGujY1rjR0UgfqnH0kPsKopHYs0ZFY5HndPsK-pyfqnHnYPW-xnHnLrjFxnHDsP1uxnHfzPdtkn1TLr7tkn1m4Pdtkn10LP7tknW6zP-tknW6vPdtkn1nzndtknjRvn-tknWTznsKBpHYs0AdW5Hf3nHf1nWns0Z7spyfqn0Kkmv-b5H00ThIYmyTqn0KEIhsqnH0snj0snaY4g1DknWDVn0K9mWYsg100ugFM5H00TZ0qn0K8IM0qna3snj0snj0sn0KVIZ0qn0KbuAqs5H00ThCqn0KbugmqTAn0uMfqn0KspjYs0Aq15H00mMTqnH00UMfqn0K1XWY0IZN15HnYrjb4Pj6dPHDsnWRLrjf1njR0ThNkIjYkPjnsrjTLP1fsP1mY0ZPGujdhuj0dmWDYPH0snH6krjfk0AF_5H00mLFW5HRdn1fv%26ck%3D948.17.99.240.481.295.141.1572%26shh%3Dwww.baidu.com%26sht%3Dbaidu%26us%3D4.0.1.0.1.311.30%26ie%3Dutf-8%26f%3D8%26tn%3Dbaidu%26wd%3D%25E5%25B0%258F%25E7%25B1%25B3%2520%2520%25E5%25AE%25B6%25E8%25A3%2585%26inputT%3D3277; testcookie=testvalue; Hm_lvt_0ca84157e738c85bb889dc38b978064d=1430876433,1430876437,1430876624,1430877762; Hm_lpvt_0ca84157e738c85bb889dc38b978064d=1430879820; __utma=149996462.496141731.1430876434.1430876434.1430877762.2; __utmc=149996462; __utmz=149996462.1430877762.2.2.utmcsr=baidu|utmccn=(organic)|utmcmd=organic|utmctr=%E5%B0%8F%E7%B1%B3%20%20%E5%AE%B6%E8%A3%85; QIAO_CK_6087028_R=https%3A//www.baidu.com/baidu.php%3Fsc.Kf0000jz6UxuAENyjv4eix1fno5D00EakBWls9PpRPlqEoxYRU5sIbhyyvLNkSR8tcL9-kTC0beKhmlgYU8Xob3JwUY0-9WBqqssv1MRrNTU0S2rzEudRvK5JqfJsyK1s5dRkjs.DD_KOpeP-X1D9i_nYQZu8lIh4f.U1YY0ZDqY2ZjdzRznQ1ide00IjLfCT5gFHcsEPQg_0KGUHYznWR0u1dBuZCs0ZNG5yF9pywd0ZKGujYk0APGujY1rjR0UgfqnH0kPsKopHYs0ZFY5HndPsK-pyfqnHnYPW-xnHnLrjFxnHDsP1uxnHfzPdtkn1TLr7tkn1m4Pdtkn10LP7tknW6zP-tknW6vPdtkn1nzndtknjRvn-tknWTznsKBpHYs0AdW5Hf3nHf1nWns0Z7spyfqn0Kkmv-b5H00ThIYmyTqn0KEIhsqnH0snj0snaY4g1DknWDVn0K9mWYsg100ugFM5H00TZ0qn0K8IM0qna3snj0snj0sn0KVIZ0qn0KbuAqs5H00ThCqn0KbugmqTAn0uMfqn0KspjYs0Aq15H00mMTqnH00UMfqn0K1XWY0IZN15HnYrjb4Pj6dPHDsnWRLrjf1njR0ThNkIjYkPjnsrjTLP1fsP1mY0ZPGujdhuj0dmWDYPH0snH6krjfk0AF_5H00mLFW5HRdn1fv%26ck%3D948.17.99.240.481.295.141.1572%26shh%3Dwww.baidu.com%26sht%3Dbaidu%26us%3D4.0.1.0.1.311.30%26ie%3Dutf-8%26f%3D8%26tn%3Dbaidu%26wd%3D%25E5%25B0%258F%25E7%25B1%25B3%2520%2520%25E5%25AE%25B6%25E8%25A3%2585%26inputT%3D3277");
            
            
            conn.setRequestProperty("Host", "www.ikongjian.com");
            conn.setRequestProperty("Referer", "http://www.ikongjian.com/shh/showReservation?reservationCode=qdmcu1");
            conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.3; WOW64; rv:37.0) Gecko/20100101 Firefox/37.0");
            conn.setRequestProperty("X-Requested-With", "XMLHttpRequest");

            
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }    
    public static class MyCookiesDemo {
    	
    	private static CookieManager manager = new CookieManager();
    	
    	public static void storecoo(URI uri,String strcoo) {
    	
    		// 创建一个默认的 CookieManager
    		

    		// 将规则改掉，接受所有的 Cookie
    		manager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);

    		// 保存这个定制的 CookieManager
    		CookieHandler.setDefault(manager);

    		// 接受 HTTP 请求的时候，得到和保存新的 Cookie
    		HttpCookie cookie = new HttpCookie("Cookie: ", strcoo);
    		cookie.setMaxAge(6000);
    		manager.getCookieStore().add(uri, cookie);
    	}
    	
    	public static HttpCookie getcookies(){
    		
    		HttpCookie res = null;
    		// 使用 Cookie 的时候：
    		// 取出 CookieStore
    		CookieStore store = manager.getCookieStore();

    		// 得到所有的 URI
    		List<URI> uris = store.getURIs();
    		for (URI ur : uris) {
    			// 筛选需要的 URI
    			// 得到属于这个 URI 的所有 Cookie
    			List<HttpCookie> cookies = store.get(ur);
    			for (HttpCookie coo : cookies) {
    				res = coo;
    			}
    		}
    		return res;
    	}
    }
    
    
    public static void main(String[] args) {
        //发送 GET 请求
//        String s=HttpRequest.sendGet("http://localhost:6144/Home/RequestString", "key=123&v=456");
//        System.out.println(s);
//        
        //发送 POST 请求
        String sr=HttpRequest.sendPost("http://www.ikongjian.com/shh/panicBuy", "reservationCode=qdmcu1&cName=%E8%B5%B5%E4%BD%B3%E4%BB%91&cGender=1&cPhone=13901167343&cRegionId=3&cAddress=%E9%87%91%E9%9A%85%E4%B8%BD%E6%B8%AF&apartment=%E4%B8%89%E5%B1%85%E5%AE%A4&area=129.00&buildYear=2005");
        System.out.println(sr);
    }
}
