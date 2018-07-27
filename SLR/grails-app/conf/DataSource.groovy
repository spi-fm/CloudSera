dataSource {
    pooled = true
    jmxExport = true
    driverClassName = "com.mysql.jdbc.Driver"
    username = "sa"
    password = ""
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
//    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
    singleSession = true // configure OSIV singleSession mode
}

// environment specific settings
environments {
    development {
      dataSource {
        dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
        url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
			  dialect = es.uca.pfc.bbdd.ImprovedH2Dialect
      }
  		dataSource {
  			pooled = true
  			dbCreate = "update"
  			driverClassName = "com.mysql.jdbc.Driver"
  			dialect = "es.uca.pfc.bbdd.ImprovedMySQLDialect"
  			url = "jdbc:mysql://localhost:3306/pfcslr?autoReconnect=true&useUnicode=yes&characterEncoding=UTF-8"
  			username = "root"
  			password = ""
  		}
    }
    test {
      dataSource {
        dbCreate = "update"
        url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
      }
    }
  production {
    dataSource {
  		pooled = true
  		dbCreate = "update"
  		driverClassName = "com.mysql.jdbc.Driver"
  		dialect = "es.uca.pfc.bbdd.ImprovedMySQLDialect"
  		url = "jdbc:mysql://localhost:3306/pfcslr?autoReconnect=true&useUnicode=yes&characterEncoding=UTF-8"
  		username = "root"
  		password = "broly"
  	}

	  properties {
			maxActive = -1
			maxIdle = 8
			minIdle = 0
			maxWait = 180000
			minEvictableIdleTimeMillis = 1000 * 60 * 15
			timeBetweenEvictionRunsMillis = 1000 * 60 * 15
			numTestsPerEvictionRun = 3
			testOnBorrow = true
			testWhileIdle = true
			testOnReturn = false
			validationQuery = "select 1"
		}
  }
}
