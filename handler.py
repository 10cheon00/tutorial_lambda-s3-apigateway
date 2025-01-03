import json

def lambda_handler(event, context):
    body = f'text is {event['text']}.'
    
    return {
        'statusCode': 200,
        'body': json.dumps(body)
    }
