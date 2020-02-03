<template>
  <el-dropdown size="small" class="d2-mr">
    <span class="btn-text">{{info && info.loginInfo ? `你好 ${info.loginInfo.userName}` : '未登录'}}</span>
    <el-dropdown-menu slot="dropdown">
      <el-dropdown-item @click.native="logOff">
        <d2-icon name="power-off" class="d2-mr-5"/>
        注销
      </el-dropdown-item>
    </el-dropdown-menu>
  </el-dropdown>
</template>

<script>
import { mapState, mapActions } from 'vuex'
export default {
  computed: {
    ...mapState('d2admin/user', [
      'info'
    ])
  },
  methods: {
    ...mapActions('d2admin/login', [
      'userLoginOut'
    ]),
    /**
     * @description 登出
     */
    logOff () {
      this.userLoginOut({
        confirm: true
      })
    }
  }
}
</script>
