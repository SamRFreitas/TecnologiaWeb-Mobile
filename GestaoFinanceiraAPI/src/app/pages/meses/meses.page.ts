import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Mes } from 'src/app/models/mes';
import {MesesService} from "../../service/meses.service"
import { LoadingController } from '@ionic/angular';

@Component({
  selector: 'app-meses',
  templateUrl: './meses.page.html',
  styleUrls: ['./meses.page.scss'],
})
export class MesesPage implements OnInit {

  meses: any;
  mes: Mes;

  constructor(private router: Router, public api: MesesService, public loadingController: LoadingController) { 
      this.getMeses();
  }

  async getMeses(){
    // this.meses =
    // [{"id":6,"nome":"Janeiro","saldo":109},{"id":13,"nome":"Fevereiro","saldo":80}];
    const loading = await this.loadingController.create({
      message: 'Loading'
      });
      await loading.present();
      await this.api.getMeses()
      .subscribe(res => {
      console.log(res);
      this.meses = res;
      loading.dismiss();
      }, err => {
      console.log(err);
      loading.dismiss();
    });
  }

  ngOnInit() {
    
  }
  addMes(){
    this.router.navigate(['/edit-mes', 0]);
  }
  editMes(id: number) {
    this.router.navigate(['/edit-mes', id]);
  }
  // async removeMes(id: number){
  //   const loading = await this.loadingController.create({
  //     message: 'Apagando'
  //   });
  //   await loading.present();
  //   await this.api.deleteMeses(id)
  //   .subscribe(res => {
  //     console.log(res);
  //     this.getMeses();
  //     loading.dismiss();
  //   }, err => {
  //     console.log(err);
  //     loading.dismiss();
  //   });

  // }

}
