package org.mosh.hibernate.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ImportResource({ "classpath:persistence-config.xml" })
public class HibernateXMLConfig{
   //
}
