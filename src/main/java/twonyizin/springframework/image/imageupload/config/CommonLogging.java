package twonyizin.springframework.image.imageupload.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * @author TheinZaw 2020/03/25
 */
@Aspect
@Configuration
public class CommonLogging {


	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// For Controller
	@Before("execution(* twonyizin.springframework.image.imageupload.controllers.*.*(..))")
	public void before(JoinPoint joinPoint) {
		logger.info("Start method in Controller: {}", joinPoint);
	}

	/*
	 * @AfterReturning(value =
	 * "execution(* com.isgm.ihrms.employee.controllers.*.*(..))", returning =
	 * "result") public void afterReturning(JoinPoint joinPoint, Object result) {
	 * logger.info("{} returned with value in Controller{}", joinPoint, result);
	 * logger.info("{}", gson.toJson(result)); }
	 */

	@AfterThrowing(value = "execution(* twonyizin.springframework.image.imageupload.controllers.*.*(..))", throwing = "e")
	public void afterThrowing(JoinPoint joinPoint, Exception e) {
		logger.debug("Exception in Controller : {} {}", joinPoint, e.getMessage());
	}

	@After("execution(* twonyizin.springframework.image.imageupload.controllers.*.*(..))")
	public void after(JoinPoint joinPoint) {
		logger.info("End method in Controller {}", joinPoint);

	}

	// For Repository
	@Before("execution(* twonyizin.springframework.image.imageupload.repositories.*.*(..))")
	public void beforeInRepository(JoinPoint joinPoint) {
		logger.info("Start method in Repository: {}", joinPoint);
	}

	/*
	 * @AfterReturning(value =
	 * "execution(* com.isgm.ihrms.employee.repositories.*.*(..))", returning =
	 * "result") public void afterReturningInRepository(JoinPoint joinPoint, Object
	 * result) { logger.info("{} returned with value in Repository{}", joinPoint,
	 * result); logger.info("{}", gson.toJson(result)); }
	 */

	@AfterThrowing(value = "execution(* twonyizin.springframework.image.imageupload.repositories.*.*(..))", throwing = "e")
	public void afterThrowingInRepository(JoinPoint joinPoint, Exception e) {
		logger.debug("Exception in Repository : {} {}", joinPoint, e.getMessage());
	}

	@After("execution(* twonyizin.springframework.image.imageupload.repositories.*.*(..))")
	public void afterInRepository(JoinPoint joinPoint) {
		logger.info("End method in Repository {}", joinPoint);

	}

	// For ServiceImpl
	@Before("execution(* twonyizin.springframework.image.imageupload.services.Impl.*.*(..))")
	public void beforeInService(JoinPoint joinPoint) {
		logger.info("Start method in ServiceImpl: {}", joinPoint);
	}

	/*
	 * @AfterReturning(value =
	 * "execution(* com.isgm.ihrms.employee.services.Impl.*.*(..))", returning =
	 * "result") public void afterReturningInService(JoinPoint joinPoint, Object
	 * result) { logger.info("{} returned with value in ServiceImpl{}", joinPoint,
	 * result); logger.info("{}", gson.toJson(result)); }
	 */

	@AfterThrowing(value = "execution(* twonyizin.springframework.image.imageupload.services.Impl.*.*(..))", throwing = "e")
	public void afterThrowingInService(JoinPoint joinPoint, Exception e) {
		logger.debug("Exception in ServiceImpl : {} {}", joinPoint, e.getMessage());

	}

	@After("execution(* twonyizin.springframework.image.imageupload.services.Impl.*.*(..))")
	public void afterInService(JoinPoint joinPoint) {
		logger.info("End method in ServiceImpl {}", joinPoint);

	}

}
