<template>
  <div class="container">
     <div> <h1 style="text-align: center;">Spring Boot + Vue JS </h1></div>
     <div style="float: left; padding: 20px;"> <button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#exampleModal">Create +</button></div>
     
  
      <table class="table table-bordered table-striped">
        <thead >
          <tr style="text-align: center;">
          <th>ID</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Age</th>
          <th>Gender</th>
          <th>Email</th>
          <th>Address</th>
          <th>Status</th>
          <th>Custom</th>
         </tr>
        </thead>
       <tbody>
        <tr v-for="list in informationList" :key="list.id" style="text-align: start;">
          <td style="text-align: center;">{{ list.id }}</td>
          <td>{{ list.firstName }}</td>
          <td>{{ list.lastName }}</td>
          <td>{{ list.age }}</td>
          <td>{{ list.gender }}</td>
          <td>{{ list.email }}</td>
          <td>{{ list.address }}</td>
          <td>{{ list.status }}</td>
          <td>
            <button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#editModal" @click="listEdit(list.id)" >Edit</button> / 
            <button class="btn btn-danger" @click="deleteInfor(list.id)" >Delete</button></td>
         </tr>
       </tbody>
      </table>

<!-- Modal Add -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body" style="text-align: start;">
      <form action="#" method="post" >
        <div class="mb-3">
  <label for="1" class="form-label">First Name</label>
  <input type="text" v-model="addData.firstName" class="form-control" id="1" placeholder="Enter First Name">
</div>
<div class="mb-3">
  <label for="2" class="form-label">Last Name</label>
  <input type="text" v-model="addData.lastName" class="form-control" id="2" placeholder="Enter Last Name">
</div>
<div class="mb-3">
  <label for="3" class="form-label">Age</label>
  <input type="text" v-model="addData.age" class="form-control" id="3" placeholder="Enter Age">
</div>

<div class="mb-3">
  <label for="4" class="form-label">Gender</label>
  <input type="text" v-model="addData.gender" class="form-control" id="4" placeholder="Enter Gender">
</div>

<div class="mb-3">
  <label for="5" class="form-label">Email</label>
  <input type="email" v-model="addData.email" class="form-control" id="5" placeholder="Enter Name@example.com">
</div>
<div class="mb-3">
  <label for="6" class="form-label"> Address</label>
  <input type="text" v-model="addData.address" class="form-control" id="6" placeholder="Enter Address">
</div>
<div class="mb-3">
  <label for="7" class="form-label">Your Status</label>
  <input type="text" v-model="addData.status" class="form-control" id="7" placeholder="Enter Status">
</div>
      </form>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-bs-dismiss="modal" @click="createData()">Save</button>
      </div>
    </div>
  </div>
</div>

<!-- Modal Edit -->
<div class="modal fade" id="editModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Update Information</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body" style="text-align: start;">
      <form action="#" method="post" >
        <div class="mb-3">
  <label for="1" class="form-label">First Name</label>
  <input type="text" v-model="editData.firstName" class="form-control" id="1" >
</div>
<div class="mb-3">
  <label for="2" class="form-label">Last Name</label>
  <input type="text" v-model="editData.lastName" class="form-control" id="2" >
</div>
<div class="mb-3">
  <label for="3" class="form-label">Age</label>
  <input type="text" v-model="editData.age" class="form-control" id="3" >
</div>

<div class="mb-3">
  <label for="4" class="form-label">Gender</label>
  <input type="text" v-model="editData.gender" class="form-control" id="4" >
</div>

<div class="mb-3">
  <label for="5" class="form-label">Email</label>
  <input type="email" v-model="editData.email" class="form-control" id="5" >
</div>
<div class="mb-3">
  <label for="6" class="form-label"> Address</label>
  <input type="text" v-model="editData.address" class="form-control" id="6" >
</div>
<div class="mb-3">
  <label for="7" class="form-label">Your Status</label>
  <input type="text" v-model="editData.status" class="form-control" id="7" >
</div>
      </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-bs-dismiss="modal" @click="updateData()">Save</button>
      </div>
    </div>
  </div>
</div>


  </div>
</template>
<script>
import axios from 'axios'
import ServiceInfo from '../Service/ServiceInfo'
export default {
  name:'HelloWorld',
  data() {
     return {
      informationList: [],
      addData: {
        firstName: '',
        lastName: '',
        age: 0,
        gender: '',
        email: '',
        address: '',
        status: ''
      },
      editData: {
        firstName: '',
        lastName: '',
        age: 0,
        gender: '',
        email: '',
        address: '',
        status: ''
      },
      showModalEdit: false,
      index: 0
     }
  },
  created() {
     this.fetchData()
  },
  methods: {
      fetchData() {
        ServiceInfo.getInfo().then((res) => {
          // axios.get('http://localhost:9090/api/info').then((res) => {
              this.informationList = res.data
          })
      },
   createData() {
     if(this.addData.id == '' || this.addData.id == null){
      axios
      .post('http://localhost:9090/api/info', 
      {firstName: this.addData.firstName, lastName: this.addData.lastName, age: this.addData.age, email: this.addData.email, address: this.addData.address, status: this.addData.status},
      {headers:{"Content-Type" : "application/json"}}
     ).then(res => {
       this.addData = res.data
     })
     this.fetchData()
     }
   },
   listEdit(id){
    axios 
    .get(`http://localhost:9090/api/info/${id}`, this.editData
    ).then((res) => {
      this.editData = res.data
    })
   },
   updateData() {
    if(this.editData != '' || this.editData != null){
        axios
     .put(`http://localhost:9090/api/info/` + this.editData.id,
      {firstName: this.editData.firstName, lastName: this.editData.lastName, age: this.editData.age, email: this.editData.email, address: this.editData.address, status: this.editData.status},
      {headers:{"Content-Type" : "application/json"}}
    ).then(res => {
      console.log(this.editData = res.data)
      this.fetchData()
    })
   } 
    },
    deleteInfor(id){
      axios
      .delete(`http://localhost:9090/api/info/${id}`,
      {headers:{"Content-Type" : "application/json"}}
    ).then((res) => {
      // this.addData = res.data
      console.log(this.addData = res.data)
      this.fetchData()
    })
    }
  },

}
</script>
