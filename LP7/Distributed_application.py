
import requests
import multiprocessing
import os

def consume_web_service(app_id):
    url = f'http://127.0.0.1:5000/api/hello?app_id={app_id}'

    response = requests.get(url)
    if response.status_code == 200:
        data = response.json()
        message = data['message']
        print(f'Response from App ID {app_id}:', message)
    else:
        print(f'Failed to fetch data from the web service for App ID {app_id}')

if __name__ == '__main__':
    num_instances = 5  # Number of distributed application instances to run

    processes = []
    for i in range(num_instances):
        process = multiprocessing.Process(target=consume_web_service, args=(i,))
        process.start()
        processes.append(process)

    for process in processes:
        process.join()
