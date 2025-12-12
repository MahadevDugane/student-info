//package com.example.studentInfo.config;
//
//import com.example.studentInfo.repository.StudentRepository;
//import com.example.studentInfo.service.StudentInfoService;
//import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
//import org.springframework.cache.CacheManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.net.URISyntaxException;
//import java.time.Duration;
//
//@Configuration
//public class StudentConfig {
////    @Bean
////    public StudentInfoService getStudentInfo(){
////        return new StudentInfoService();
////    }
//@Bean
//public JCacheManagerCustomizer cacheManagerCustomizer() {
//    return cm -> {
//        cm.createCache("products", new MutableConfiguration<>()
//                .setExpiryPolicyFactory(CreatedExpiryPolicy.factoryOf(Duration.ofMinutes(10)))
//                .setStoreByValue(false)
//                .setStatisticsEnabled(true));
//    };
//}
//
//    @Bean
//    public CacheManager cacheManager() throws URISyntaxException {
//        return Caching.getCachingProvider().getCacheManager(
//                getClass().getResource("/ehcache.xml").toURI(),
//                getClass().getClassLoader());
//    }
//
//}
