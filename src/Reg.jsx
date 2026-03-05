import axios from "axios";
import { useState } from "react";

function Reg()
{
    const[data,setdata] = useState(
        {
            username:"",
            email:"",
            password:""
        }
    )
    const changeName=(e)=>
    {
        setdata({...data,[e.target.name]:e.target.value })
    }
    const submit = async() =>
    {
        try{
            //const res=await axios.post("http://localhost:8080/reg",data)
            const res=await axios.post("https://demo-3-vlk6.onrender.com",data)
            alert(res.data)
        }
        catch(xyz)
        {
            alert(xyz.response?.data||"Error")
        }
    }
    return(
        <>
        <h1> I am duck</h1>
        <input onChange={changeName} name="username" placeholder=" Enter Username"/>
        <input onChange={changeName} name="email" placeholder=" Enter Email"/>
        <input onChange={changeName} name="password" placeholder=" Enter Password"/>
        <button onClick={submit}>register</button>
        </>
    )
}
export default Reg;