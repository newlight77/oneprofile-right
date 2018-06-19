package com.newlight77.bhavio.right.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages= "com.bhavio.right.repository.jpa")
@EntityScan(basePackages = "com.bhavio.right.entity.jpa")
public class RightJpaConfiguration {
  RightJpaConfiguration() {
  }

}
