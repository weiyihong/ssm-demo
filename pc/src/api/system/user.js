import request from '@/plugin/axios'

export function Login (data) {
  return request({
    url: '/system/user/login',
    method: 'post',
    data
  })
}

export function Logout (data) {
  return request({
    url: '/system/user/logout',
    method: 'get',
    params: data
  })
}

export function Role (data) {
  return request({
    url: '/system/user/role',
    method: 'get',
    params: data
  })
}

export function ChangeRole (roleId) {
  return request({
    url: `/system/role/change/${roleId}`,
    method: 'get'
  })
}

export function Menu () {
  return request({
    url: `/system/menu/roleMenu`,
    method: 'get'
  })
}


