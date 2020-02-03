<template>
  <el-cascader
    v-model="value"
    :options="options"
    :props="{ expandTrigger: 'hover' }"
    @change="handleChange"/>
</template>

<script>
import { mapState,mapActions } from 'vuex'
import request from '@/plugin/axios'
import util from '@/libs/util.js'
export default {
  computed: {
    ...mapState('d2admin/user', [
      'info'
    ])
  },
  data () {
    return {
      value:[],
      options:[]
    }
  },
  methods: {
    ...mapActions('d2admin/login', [
      'roleChange','getMenu'
    ]),
    getRole () {
      request({
        url: '/system/user/role',
        method: 'get'
      }).then(res => {
        this.options = util.sys.options(res)
        this.value = [`${this.info.loginInfo.sysId}`,`${this.info.loginInfo.roleId}`]
        this.getMenu().then(menu => {
          // 设置顶栏菜单
          this.$store.commit('d2admin/menu/headerSet', menu)
          // 设置侧边栏菜单
          this.$store.commit('d2admin/menu/asideSet', menu)
        })
      })
    },
    handleChange (value) {
      this.roleChange(value[1]).then(res => {
        this.getMenu().then(menu => {
          // 设置顶栏菜单
          this.$store.commit('d2admin/menu/headerSet', menu)
          // 设置侧边栏菜单
          this.$store.commit('d2admin/menu/asideSet', menu)
        })
      })
    }
  },
  mounted () {
    this.getRole()
  }
}
</script>
