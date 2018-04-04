dataSource {
    pooled = true
    jmxExport = true
    driverClassName = "org.h2.Driver"
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
		/*dataSource {
			pooled = true
			dbCreate = "update"
			driverClassName = "com.mysql.jdbc.Driver"
			dialect = "es.uca.pfc.bbdd.ImprovedMySQLDialect"
			url = "jdbc:mysql://localhost:3306/pfcslr?autoReconnect=true&useUnicode=yes&characterEncoding=UTF-8"
			username = "root"
			password = "admin"
		}*/
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
			password = "mysql"
		}
		
		/*properties {
			jmxEnabled = true
			initialSize = 5
			maxActive = 50
			minIdle = 5
			maxIdle = 25
			maxWait = -10000
			maxAge = 10 * 60000
			timeBetweenEvictionRunsMillis = 5000
			numTestsPerEvictionRun = 3
			minEvictableIdleTimeMillis = 60000
			validationQuery = "SELECT 1"
			validationQueryTimeout = 3
			validationInterval = 15000
			testOnBorrow = true
			testWhileIdle = true
			testOnReturn = false
			jdbcInterceptors = "ConnectionState;StatementCache(max=200)"
			defaultTransactionIsolation = java.sql.Connection.TRANSACTION_READ_COMMITTED
		 }*/
		/*properties {
			// See http://grails.org/doc/latest/guide/conf.html#dataSource for documentation
			jmxEnabled = true
			initialSize = 5
			maxActive = 50
			minIdle = 5
			maxIdle = 25
			maxWait = 10000
			maxAge = 10 * 60000
			timeBetweenEvictionRunsMillis = 5000
			minEvictableIdleTimeMillis = 60000
			validationQuery = "SELECT 1"
			validationQueryTimeout = 3
			validationInterval = 15000
			testOnBorrow = true
			testWhileIdle = true
			testOnReturn = false
			testOnConnect = true
			jdbcInterceptors = "ConnectionState"
			defaultTransactionIsolation = java.sql.Connection.TRANSACTION_READ_COMMITTED
		}*/
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
