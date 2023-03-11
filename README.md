
```
Free Plan Details

App Services

A resource group is a container that holds resources for an azure solution

for JAR we can use embedded server otherwise we can use WAR for tomcat server
```

<img width="1261" alt="Screenshot 2023-03-12 at 12 51 00 AM" src="https://user-images.githubusercontent.com/43849911/224507649-c0bbcef9-5945-421a-a659-b5029cdeecef.png">

<img width="1792" alt="Screenshot 2023-03-12 at 1 00 48 AM" src="https://user-images.githubusercontent.com/43849911/224508017-a699aeb7-8192-48aa-a712-8d9c55e64623.png">

<img width="1790" alt="Screenshot 2023-03-12 at 1 19 22 AM" src="https://user-images.githubusercontent.com/43849911/224508703-83a24896-5748-4876-8256-3deaff9e7eab.png">

<img width="1790" alt="Screenshot 2023-03-12 at 1 21 38 AM" src="https://user-images.githubusercontent.com/43849911/224508821-8e20df4b-f30e-442c-b0c4-d6e8a7990b86.png">

<img width="1789" alt="Screenshot 2023-03-12 at 1 22 38 AM" src="https://user-images.githubusercontent.com/43849911/224508848-721fbbee-bb6a-4988-8015-2c7b614d8c83.png">

<img width="1792" alt="Screenshot 2023-03-12 at 1 23 00 AM" src="https://user-images.githubusercontent.com/43849911/224508855-562e887b-a0c4-4555-b2d4-e0348d5ec4de.png">

<img width="1788" alt="Screenshot 2023-03-12 at 1 28 57 AM" src="https://user-images.githubusercontent.com/43849911/224509097-1f2d8fe6-a478-4c00-9b76-e0194f8bf90a.png">

<img width="1789" alt="Screenshot 2023-03-12 at 1 29 45 AM" src="https://user-images.githubusercontent.com/43849911/224509125-a4d3fb26-b94b-4151-ba53-7d24c7d5995e.png">

<img width="1787" alt="Screenshot 2023-03-12 at 1 30 07 AM" src="https://user-images.githubusercontent.com/43849911/224509139-88169eee-e5b6-4847-a9a8-9d52fc9ceaca.png">

<img width="1790" alt="Screenshot 2023-03-12 at 1 36 26 AM" src="https://user-images.githubusercontent.com/43849911/224509375-b483b2df-6558-44f2-be67-3d05fb9b031a.png">

<img width="1788" alt="Screenshot 2023-03-12 at 1 37 42 AM" src="https://user-images.githubusercontent.com/43849911/224509416-5a32bad4-1a8c-49ca-a6e1-6da9a5a6f861.png">

<img width="1792" alt="Screenshot 2023-03-12 at 1 40 18 AM" src="https://user-images.githubusercontent.com/43849911/224509525-b8832356-dbf5-43b0-ab78-2ebb7dd3e1ca.png">

<img width="1789" alt="Screenshot 2023-03-12 at 1 41 11 AM" src="https://user-images.githubusercontent.com/43849911/224509562-3dc89a1f-4b63-46fd-aa38-abb211364376.png">

<img width="1791" alt="Screenshot 2023-03-12 at 1 41 29 AM" src="https://user-images.githubusercontent.com/43849911/224509575-3f2c3951-31e2-4f39-9ce0-81c6b4e98b82.png">

<img width="1786" alt="Screenshot 2023-03-12 at 1 43 03 AM" src="https://user-images.githubusercontent.com/43849911/224509638-4d1a9c9a-0f29-4b90-a0f0-9e28aadfc976.png">

<img width="1787" alt="Screenshot 2023-03-12 at 1 43 25 AM" src="https://user-images.githubusercontent.com/43849911/224509646-23fc83c7-b681-4227-9f73-60bffe00aa45.png">

<img width="1789" alt="Screenshot 2023-03-12 at 1 46 39 AM" src="https://user-images.githubusercontent.com/43849911/224509757-04193d65-42c5-4f78-9509-ba9a45b9135d.png">

<img width="1789" alt="Screenshot 2023-03-12 at 1 49 04 AM" src="https://user-images.githubusercontent.com/43849911/224509843-31e42366-953d-4a91-a934-5070d1c54e3b.png">

<img width="1771" alt="Screenshot 2023-03-12 at 1 49 37 AM" src="https://user-images.githubusercontent.com/43849911/224509860-8f26abfe-39d4-4fb8-90d0-7b864b19d103.png">

<img width="1788" alt="Screenshot 2023-03-12 at 1 51 07 AM" src="https://user-images.githubusercontent.com/43849911/224509917-7b138628-d4a2-4b23-834c-16aea7bb0e6d.png">

<img width="1788" alt="Screenshot 2023-03-12 at 1 51 38 AM" src="https://user-images.githubusercontent.com/43849911/224509934-370d7364-b34e-4bb4-8aa3-d28725bcbd40.png">

```
# Docs for the Azure Web Apps Deploy action: https://github.com/Azure/webapps-deploy
# More GitHub Actions for Azure: https://github.com/Azure/actions

name: Build and deploy JAR app to Azure Web App - spring-azure-demo-by-sai

on:
  push:
    branches:
      - main
  workflow_dispatch:

jobs:
  build:
    runs-on: ubuntu-latest

    steps:
      - uses: actions/checkout@v2

      - name: Set up Java version
        uses: actions/setup-java@v1
        with:
          java-version: '17'

      - name: Build with Maven
        run: mvn clean install

      - name: Upload artifact for deployment job
        uses: actions/upload-artifact@v2
        with:
          name: java-app
          path: '${{ github.workspace }}/target/*.jar'

  deploy:
    runs-on: ubuntu-latest
    needs: build
    environment:
      name: 'production'
      url: ${{ steps.deploy-to-webapp.outputs.webapp-url }}
    
    steps:
      - name: Download artifact from build job
        uses: actions/download-artifact@v2
        with:
          name: java-app

      - name: Deploy to Azure Web App
        id: deploy-to-webapp
        uses: azure/webapps-deploy@v2
        with:
          app-name: 'spring-azure-demo-by-sai'
          slot-name: 'production'
          publish-profile: ${{ secrets.AzureAppService_PublishProfile_d4842f18bd8c4e39bea8f693372b95b8 }}
          package: '*.jar'
```

<img width="1787" alt="Screenshot 2023-03-12 at 1 53 18 AM" src="https://user-images.githubusercontent.com/43849911/224510004-fc5d5512-ba70-4aec-9072-976c19b4cd5c.png">

<img width="1786" alt="Screenshot 2023-03-12 at 1 55 33 AM" src="https://user-images.githubusercontent.com/43849911/224510089-40f650eb-afb7-48eb-94a5-ada466b5bc46.png">

<img width="1792" alt="Screenshot 2023-03-12 at 1 56 08 AM" src="https://user-images.githubusercontent.com/43849911/224510113-694284bb-8bb9-48f0-91ac-d56113798985.png">

<img width="1792" alt="Screenshot 2023-03-12 at 2 00 01 AM" src="https://user-images.githubusercontent.com/43849911/224510250-3f637883-8c16-48f5-87c2-695e6e4cc009.png">

<img width="1786" alt="Screenshot 2023-03-12 at 2 02 58 AM" src="https://user-images.githubusercontent.com/43849911/224510325-aeabdfb9-1e3d-4859-aa9e-7f0eeaaaafba.png">

<img width="1778" alt="Screenshot 2023-03-12 at 2 04 09 AM" src="https://user-images.githubusercontent.com/43849911/224510364-7daf105a-5c93-42fd-bc58-9e86e1999baa.png">

<img width="1788" alt="Screenshot 2023-03-12 at 2 04 56 AM" src="https://user-images.githubusercontent.com/43849911/224510401-aef39483-84c5-45b9-99c5-6c29f3e96ee8.png">

<img width="1782" alt="Screenshot 2023-03-12 at 2 05 50 AM" src="https://user-images.githubusercontent.com/43849911/224510440-a47780dd-183d-4695-84ab-73af4052afd2.png">

<img width="1786" alt="Screenshot 2023-03-12 at 2 07 50 AM" src="https://user-images.githubusercontent.com/43849911/224510517-a7b6d7f0-ba4e-4459-96dc-1c50bbe79803.png">

<img width="1791" alt="Screenshot 2023-03-12 at 2 08 25 AM" src="https://user-images.githubusercontent.com/43849911/224510541-bd85b8f1-af60-423f-bf35-64dd38ed11b8.png">

<img width="1772" alt="Screenshot 2023-03-12 at 2 10 09 AM" src="https://user-images.githubusercontent.com/43849911/224510613-7daef8ea-629d-4af6-b352-8a0cc54261a0.png">

<img width="1786" alt="Screenshot 2023-03-12 at 2 02 58 AM" src="https://user-images.githubusercontent.com/43849911/224510619-b1304b62-f717-4d89-9d5c-ce93d45c7a2f.png">

<img width="1784" alt="Screenshot 2023-03-12 at 2 19 50 AM" src="https://user-images.githubusercontent.com/43849911/224511004-e07fcabe-6c4a-4e14-9542-c9f7cd7484c5.png">

<img width="1782" alt="Screenshot 2023-03-12 at 2 31 39 AM" src="https://user-images.githubusercontent.com/43849911/224511458-0a90483c-620a-4fbe-8963-b12a36cced4c.png">

<img width="1790" alt="Screenshot 2023-03-12 at 2 33 26 AM" src="https://user-images.githubusercontent.com/43849911/224511519-60c69eba-2920-48ab-beea-18c993727c83.png">

<img width="688" alt="Screenshot 2023-03-12 at 2 34 27 AM" src="https://user-images.githubusercontent.com/43849911/224511554-b3d77d3e-b3cd-4efe-be86-121ccc1f5273.png">

<img width="1784" alt="Screenshot 2023-03-12 at 2 35 31 AM" src="https://user-images.githubusercontent.com/43849911/224511594-8846d76e-8747-4cb4-99bf-86a52e0ac060.png">

<img width="1792" alt="Screenshot 2023-03-12 at 2 37 51 AM" src="https://user-images.githubusercontent.com/43849911/224511674-8932afd9-8b46-4a8c-91e8-8607ce492e70.png">



