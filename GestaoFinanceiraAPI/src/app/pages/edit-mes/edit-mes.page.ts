import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Mes } from '../../models/mes';
import {MesesService} from "../../service/meses.service";

@Component({
  selector: 'app-edit-mes',
  templateUrl: './edit-mes.page.html',
  styleUrls: ['./edit-mes.page.scss'],
})
export class EditMesPage implements OnInit {
  mes: Mes;
  loadingController: any;
  constructor(private actRoute: ActivatedRoute, private router: Router,
    private api, private MesesService) {
    this.mes = new Mes();
  }
  async getById(id:number) {
      const loading = await this.loadingController.create({
      message: 'Loading'
      });
      await loading.present();
      await this.api.getConvidadosById(id)
      .subscribe(res => {
      console.log(res);
      this.mes = res;
      loading.dismiss();
      }, err => {
      console.log(err);
      loading.dismiss();
      });
  }
  async save(){
    await this.api.postConvidados(this.mes)
    .subscribe(res => {
      this.router.navigateByUrl('/mes');
    }, (err) => {
      console.log(err);
    });
  }
  
 ngOnInit() {
    this.actRoute.params.subscribe(params => {
      let id:number = params['id'];
      console.log('Valor do parametro id: '+id);
      if (id!=0 && id!=null) {
        this.getById(id);
      }
      else {
        this.mes.id = 0;
        this.mes.nome = "Ninguem";
        this.mes.saldo = 0;
      }
      console.log('Valor de mes id: '+this.mes.id);
    });
 }

 ionViewWillEnter(){
    this.actRoute.params.subscribe(params => {
        let id:number = params['id'];
        console.log('Valor do parametro id: ' + id);
        if (id!=0 && id!=null) {
          this.mes.id = id;
          this.mes.nome = "Alguem";
          this.mes.saldo = 8;
        }
        else {
          this.mes.id = 0;
          this.mes.nome = "Novo";
          this.mes.saldo = 0;
        }
        console.log('Valor de mes id: '+this.mes.id);
    });
  }
}