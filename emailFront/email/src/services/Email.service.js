import { customeAxios } from "./helper";

export async function sendEmail(emailData){
  const result=(await customeAxios.post('/send',emailData)).data
  
  return result;
}