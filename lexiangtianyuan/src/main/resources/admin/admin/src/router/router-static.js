import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import shangjia from '@/views/modules/shangjia/list'
    import shangjiajianyi from '@/views/modules/shangjiajianyi/list'
    import tudi from '@/views/modules/tudi/list'
    import tudiCollection from '@/views/modules/tudiCollection/list'
    import tudiCommentback from '@/views/modules/tudiCommentback/list'
    import tudiOrder from '@/views/modules/tudiOrder/list'
    import tudiZhongzhi from '@/views/modules/tudiZhongzhi/list'
    import yonghu from '@/views/modules/yonghu/list'
    import yonghujianyi from '@/views/modules/yonghujianyi/list'
    import config from '@/views/modules/config/list'
    import dictionaryPingjia from '@/views/modules/dictionaryPingjia/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryShangjiaXingji from '@/views/modules/dictionaryShangjiaXingji/list'
    import dictionaryShangxia from '@/views/modules/dictionaryShangxia/list'
    import dictionaryTudi from '@/views/modules/dictionaryTudi/list'
    import dictionaryTudiCollection from '@/views/modules/dictionaryTudiCollection/list'
    import dictionaryTudiHaohuai from '@/views/modules/dictionaryTudiHaohuai/list'
    import dictionaryTudiShumu from '@/views/modules/dictionaryTudiShumu/list'
    import dictionaryTudiZulin from '@/views/modules/dictionaryTudiZulin/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryPingjia',
        name: '是否评价',
        component: dictionaryPingjia
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShangjiaXingji',
        name: '农民信用类型',
        component: dictionaryShangjiaXingji
    }
    ,{
        path: '/dictionaryShangxia',
        name: '上下架',
        component: dictionaryShangxia
    }
    ,{
        path: '/dictionaryTudi',
        name: '土地类型',
        component: dictionaryTudi
    }
    ,{
        path: '/dictionaryTudiCollection',
        name: '收藏表类型',
        component: dictionaryTudiCollection
    }
    ,{
        path: '/dictionaryTudiHaohuai',
        name: '土地状态',
        component: dictionaryTudiHaohuai
    }
    ,{
        path: '/dictionaryTudiShumu',
        name: '有无树',
        component: dictionaryTudiShumu
    }
    ,{
        path: '/dictionaryTudiZulin',
        name: '是否租赁',
        component: dictionaryTudiZulin
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/shangjia',
        name: '农民',
        component: shangjia
      }
    ,{
        path: '/shangjiajianyi',
        name: '农民建议',
        component: shangjiajianyi
      }
    ,{
        path: '/tudi',
        name: '土地',
        component: tudi
      }
    ,{
        path: '/tudiCollection',
        name: '土地收藏',
        component: tudiCollection
      }
    ,{
        path: '/tudiCommentback',
        name: '土地评价',
        component: tudiCommentback
      }
    ,{
        path: '/tudiOrder',
        name: '土地租赁订单',
        component: tudiOrder
      }
    ,{
        path: '/tudiZhongzhi',
        name: '种植详情',
        component: tudiZhongzhi
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }
    ,{
        path: '/yonghujianyi',
        name: '用户建议',
        component: yonghujianyi
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
