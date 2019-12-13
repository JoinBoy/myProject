import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path:'/register',
    name:'register',
    component:() => import('../views/register/Register.vue')
  },
  {
    path:'/my',
    name:"my",
    component:() => import('@/views/my/My.vue'),
    children:[{
      path:'/',
      name:'myCenter',
      component:()=>import("@/components/myCenter/MyCenter.vue")
    },
    {
      path:'/addBook',
      name:'addBook',
      component:()=>import("@/components/myCenter/AddBook.vue")
    },
    {
      path:'/addChapter',
      name:'addChapter',
      component:()=>import("@/components/myCenter/AddChapter.vue")
    },
    {
      path:'/bookManage',
      name:'bookManage',
      component:()=>import('@/components/myCenter/BookManage.vue')
    }]
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
