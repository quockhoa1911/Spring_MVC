package btt.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScans({ @ComponentScan("btt") })
@EnableWebMvc
public class AppConfig {

	// nó cần 3 cái annatation, mấy cái annotation có @ trước
	// 1 cái để biến class này thành 1 Bean trong Spring => @Configuration dùng cho các class config
	// 1 cái để Spring đọc được các Bean => để dùng đc DI vs IoC => @ComponentScans
	// @ComponentScan("d1") => Nghĩa là Spring sẽ scan qua tất cả các file nằm trong package d1
	// VD nếu có 1 bean của Spring nằm ngoài package mà Spring ko scann qua, thì Spring ko hiểu => ko chạy đc
	// cái ni tý a demo luôn
	// cái cuối cùng là để kích hoạt cái Spring MVC
	// => xong config => chạy đc rồi
	// tạo controller (để controller nằm trong package d1)
	
	// cấu hình ViewResolver
	@Bean(name = "viewResolver") // method config là auto có cái @Bean để Spring nó đọc đc, name của bean phải khác nhau
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/Views/"); // bắt đầu url đến view
		viewResolver.setSuffix(".jsp"); // kết thúc (đuôi)
		return viewResolver;
	}
	
}
