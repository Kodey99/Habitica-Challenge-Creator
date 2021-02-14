import { Component, OnInit } from '@angular/core';

import { HttpEventType, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ChallengeCreatorService } from 'src/app/services/challengeCreator.service';

@Component({
  selector: 'app-challengeCreator',
  templateUrl: './challengeCreator.component.html',
  styleUrls: ['./challengeCreator.component.css']
})
export class ChallengeCreatorComponent implements OnInit {

  selectedFiles?: FileList;
  currentFile?: File;
  userId?: string;
  apiToken?: string;
  progress = 0;
  message = '';

  blankFile?: String;
  exampleFile?: String;


  constructor(private uploadService: ChallengeCreatorService) { }

  ngOnInit(): void {}

  selectFile(event: any): void {
    this.selectedFiles = event.target.files;
  }

  addDetails(userId: string, apiToken: string): void {
    this.userId = userId;
    this.apiToken = apiToken;
  }

  upload(): void {
    this.progress = 0;

    if (this.selectedFiles && this.userId && this.apiToken) {
      const file: File | null = this.selectedFiles.item(0);

      if (file) {
        this.currentFile = file;

        this.uploadService.upload(this.currentFile, this.userId, this.apiToken).subscribe(
          (event: any) => {
            if (event.type === HttpEventType.UploadProgress) {
              this.progress = Math.round(100 * event.loaded / event.total);
            } else if (event instanceof HttpResponse) {
              this.message = "Successfully Uploaded"
            }
          },
          (err: any) => {
            console.log(err);
            this.progress = 0;
            this.message = 'Could not upload the file!';

            this.currentFile = undefined;
          });

      }

      this.selectedFiles = undefined;
    }
  }
}
