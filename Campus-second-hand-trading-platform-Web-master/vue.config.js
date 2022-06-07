module.exports = {      
    devServer: {                //配置本项目运行端口
        proxy: {                //配置代理服务器来解决跨域问题
            '/api': {
                target: 'https://534v55459p.eicp.vip',      //配置要替换的后台接口地址
                logLevel:'debug',
                secure:false,
                changOrigin: true,                      //配置允许改变Origin
                pathRewrite: {
                    '^/api': ''
                }
            },
        }
    },
  }
  