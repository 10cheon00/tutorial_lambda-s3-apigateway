import json

def lambda_handler(event, context):
    print(f'{event.get('body')}')
    req = json.loads(event.get('body'))
    
    print(req['text'])
    body = req['text']
    
    return {
        'statusCode': 200,
        'headers': 'application/json',
        'body': json.dumps(body)
    }
